# ListAnim
列表加载动画演示




> 之前介绍了各种界面间的切换动画，这次我们介绍下常用的列表加载动画

## 实现效果：

- **居中加载、和滑动动画**

![3.gif](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/397dc51dcab540e2b3fd9aaf88a545c9~tplv-k3u1fbpfcp-watermark.image)

- **从左边加载**

![1.gif](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/d1c8ad12dc2e4dc68cb9912ab564a4d7~tplv-k3u1fbpfcp-watermark.image)

- **从右边加载**

![2.gif](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/9fe105ec22e54866a64fb087a37771e6~tplv-k3u1fbpfcp-watermark.image)

## 实现代码

**加载动画：**

```
val animation = AnimationUtils.loadAnimation(this, anim)
val layoutAnimationController = LayoutAnimationController(animation)
layoutAnimationController.order = LayoutAnimationController.ORDER_NORMAL
recyclerView.layoutAnimation = layoutAnimationController
```

1. 通过`AnimationUtils`加载视图动画
2. 构造`AnimationController`对象


**滑动动画：**

```
    /**
     * View依附到Window
     */
    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.clearAnimation()

        holder.itemView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale_in_scroll))
    }
```
判断view的加载并设置动画

**视图动画xml:**

居中加载动画：scale_in_center.xml
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="200"
    android:interpolator="@android:anim/decelerate_interpolator">


    <scale
        android:fromXScale="0.3"
        android:fromYScale="0.3"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1"
        android:toYScale="1" />

    <alpha
        android:fromAlpha="0"
        android:toAlpha="1" />

</set>
```
滑动动画：scale_in_scroll.xml
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="200"
    android:interpolator="@android:anim/decelerate_interpolator">


    <scale
        android:fromXScale="0.7"
        android:fromYScale="0.7"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1"
        android:toYScale="1" />

    <alpha
        android:fromAlpha="0"
        android:toAlpha="1" />

</set>
```

## 参考

- [封装一个好看的吐司工具](https://juejin.cn/post/6996164509534519333)
- [一点也不炫酷的Navigation动画](https://juejin.cn/post/6998067266365423646)
- [Activity跳转动画及View无缝衔接，了解一下？](https://juejin.cn/post/7002105941508390919)
