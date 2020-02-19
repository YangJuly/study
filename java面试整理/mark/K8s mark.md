# K8S相关

## 1.概述

Kubernetes 是 Google 开源的容器集群管理系统，是 Borg 的一个开源版本。

Kubernetes 是用于自动部署、扩展和管理容器化应用程序的开源系统。其核心是，在集群的节点上运行容器化应用，可以进行自动化容器操作，包括部署、调度和在节点间弹性伸缩等。



Kubernetes 也是典型的集中式结构，一个 Kubernetes 集群，主要由 Master 节点和 Worker 节点组成，以及客户端命令行工具 kubectl 和其他附加项。



## 2.Master节点

运行在中心服务器上，Master 节点由 API Server、Scheduler、Cluster State Store 和 Control Manger Server 组成，负责对集群进行调度管理。

- API Server：是所有 REST 命令的入口，负责处理 REST 的操作，确保它们生效，并执行相关业务逻辑。
- Scheduler：根据容器需要的资源以及当前 Worker 节点所在节点服务器的资源信息，自动为容器选择合适的节点服务器。
- Cluster State Store：集群状态存储，默认采用 etcd，etcd 是一个分布式 key-value 存储，主要用来做共享配置和服务发现。
- Control Manager：用于执行大部分的集群层次的功能，比如执行生命周期功能（命名空间创建和生命周期、事件垃圾收集、已终止垃圾收集、级联删除垃圾收集等）和 API 业务逻辑。



## 3.Worker节点

作为真正的工作节点，运行在从节点服务器，包括 kubelet 和 kube-proxy 核心组件，负责运行业务应用的容器。

- kubelet：用于通过命令行与 API Server 进行交互，根据接收到的请求对 Worker 节点进行操作。也就是说，通过与 API Server 进行通信，接收 Master 节点根据调度策略发出的请求或命令，在 Worker 节点上管控容器（Pod），并管控容器的运行状态（比如，重新启动出现故障的 Pod）等。Pod 是 Kubernetes 的最小工作单元，每个 Pod 包含一个或多个容器。
- kube-proxy：负责为容器（Pod）创建网络代理 / 负载平衡服务，从 API Server 获取所有 Server 信息，并根据 Server 信息创建代理服务，这种代理服务称之为 Service。Kube-proxy 主要负责管理 Service 的访问入口，即实现集群内的 Pod 客户端访问 Service，或者是集群外访问 Service，具有相同服务的一组 Pod 可抽象为一个 Service。每个 Service 都有一个虚拟 IP 地址（VIP）和端口号供客户端访问。