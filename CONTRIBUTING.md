# 如何创建Demo

master分支是Demo的模板分支

创建Demo的流程：
1. 为Demo创建相关的issue
2. 基于demo-template分支创建新的demo分支，分支名格式为`issues#<id>-<demo-english-name>`
3. 修改Demo目录为指定demo的名字
4. 更新Demo目录中的README.md和.gitignore文件
5. 添加demo完成后，更新根目录下单README.md中的该demo的链接
6. 基于main做rebase，提交PR，以`--squash`进行merge
7. 关闭issue
