# RxBus

RxBus based on RxJava

# Dependency

Gradle

```gradle
compile 'top.ftas:rxbus:0.1'
```

Maven

```xml
<dependency>
  <groupId>top.ftas</groupId>
  <artifactId>rxbus</artifactId>
  <version>0.1</version>
  <type>pom</type>
</dependency>
```

lvy

```xml
<dependency org='top.ftas' name='rxbus' rev='0.1'>
  <artifact name='rxbus' ext='pom' ></artifact>
</dependency>
```

# Usage

1. Define events:

    ```java  
    public static class MessageEvent { /* Additional fields if needed */ }
    ```

2. Prepare subscribers:
    Declare and annotate your subscribing method, optionally specify a [thread mode](http://greenrobot.org/eventbus/documentation/delivery-threads-threadmode/):  

    ```java
    @Subscribe(threadMode = ThreadMode.MAIN)  
    public void onMessageEvent(MessageEvent event) {/* Do something */};
    ```
    Register and unregister your subscriber. For example on Android, activities and fragments should usually register according to their life cycle:

   ```java
    @Override
    public void onStart() {
        super.onStart();
        RxBus.getDefault().register(this);
    }
 
    @Override
    public void onStop() {
        super.onStop();
        RxBus.getDefault().unregister(this);
    }
    ```

3. Post events:

	```java
    RxBus.getDefault().post(new MessageEvent());
	```


