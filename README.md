# Decoupling

## 介绍
建立中间层，与第三方依赖的回调进行完全解耦

## 需求
最近在项目中接入第三方语音方案的时候多次更换不同的服务商，每个语音服务商接口回调定义都差不多，但每个方法的参数及返回类型差异很大，为了能随时更换第三方语音服务商而不影响项目，建立了一个`中间层`，让`应用层`间接的与`第三方api`进行通信。

## 原理

- 对第三方接口实现完全

  ```mermaid
  graph TB
    A(上层应用 type T)
    A -.转换.- B(中间层 type X)
    B -.转换.- C(下层回调 type R)
  ```

- 举例：Radio回调解耦。

  为实现和`第三方API`完全解耦，开发中间件`library`，`app`将不再依赖任何`第三方API`，`app`只构建基本数据类型与中间件`library`进行通信，中间件`library`负责转换`第三方API`所需要的数据类型。

  ```mermaid
  graph TB
    A(上层应用)
    A -.- B(中间层)
    B -.- C(下层回调)

    D(app<T>)
    D -.type T.- E(中间件 type X)
    E -.type R.- F(第三方Radio api<R>)
  ```

- 博客地址：[https://blog.csdn.net/qq_22654613/article/details/89597582](https://blog.csdn.net/qq_22654613/article/details/89597582)

## License
Decouping is released under the Apache 2.0 license. See [LICENSE](https://github.com/caohaoping/Decoupling/blob/master/LICENSE) for details.
