# Jenkins相关



#### Q1：谈谈持续继承？

一种软件实践，减少重复步骤，降低项目风险。

一个监控版本控制变化的工具，当变化被发觉时，工具可以自动编译和测试应用。

- 维护一个单一代码库
- 构建自动化
- 构建自动测试
- 快速构建
- 自动化部署



#### Q2：Jenkins你都用了哪些插件？

ssh remote hosts       这个可以在远程服务器上面执行脚本

Role Strategy Plugin   用来精细化管理权限

[Git plugin](https://wiki.jenkins.io/display/JENKINS/Git+Plugin) ：对 Git 的支持



Triggers: 事件监听并触发构建的插件。

Build tools: 实现额外构建工具的插件。



#### Q3： jenkins怎么备份恢复？

- 1、使用插件备份。

  > 例如 ThinBackup 插件。

- 2、使用 Rsync 异地备份。

- 3、使用版本控制工具进行备份。



#### Q4：Jenkins 如何实现发布和回滚？

- 发布：Jenkins 配置好代码路径( Git)，然后拉代码，打tag 。需要编译就编译，编译之后推送到发布服务器（Jenkins 里面可以调脚本），然后从分发服务器往下分发到业务服务器上。
- 回滚：按照版本号到发布服务器找到对应的版本推送。