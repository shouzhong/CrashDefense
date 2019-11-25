# CrashDefense
## 说明
很多时候，在测试的时候都没有问题，但是到线上之后就crash了，这样对用户体验是及其不好，造成一种app很差的感觉。这个库的作用就是让这些不必要的bug不造成crash。
## 使用
### 依赖
```
implementation 'com.shouzhong:CrashDefense:1.0.0'
```
### 代码
在Application的onCreate中
```
CrashDefense.install(this, new ExceptionHandler() {
    /**
     * 子线程抛出异常时始终调用该方法。主线程只有第一次抛出异常时才会调用该方法，该方法中到的throwable都会上报到bugly。
     *
     * @param thread
     * @param e
     */
    @Override
    protected void onUncaughtExceptionHappened(Thread thread, Throwable e) {
        Log.e("CrashDefense", "onUncaughtExceptionHappened:" + thread + "-->" + e.getMessage());
    }

    /**
     * 当原本导致app崩溃的主线程异常发生后，主线程再次抛出导致app崩溃异常时会调用该方法。（自己try catch住的异常不会导致app崩溃）
     * （该方法中到的throwable不会上报到bugly，也无需上报到bugly，因为本次异常可能是由于第一次主线程异常时app没有崩溃掉才发生的，只要修复了bug就不会发生该异常了)
     *
     * @param e 主线程的异常
     */
    @Override
    protected void onBandageExceptionHappened(Throwable e) {
        Log.e("CrashDefense", "onBandageExceptionHappened:" + e.getMessage());
    }

    /**
     * 进入安全模式
     *
     */
    @Override
    protected void onEnterSafeMode() {
        Log.e("CrashDefense", "onEnterSafeMode");
    }

    /**
     * 崩溃导致可能黑屏，建议直接杀死app
     *
     * @param e
     */
    @Override
    protected void onMayBeBlackScreen(Throwable e) {
        Log.e("CrashDefense", "onMayBeBlackScreen:" + e.getMessage());
    }
});
```
## 感谢
[android-notes/Cockroach](https://github.com/android-notes/Cockroach)