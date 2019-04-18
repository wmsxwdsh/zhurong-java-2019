package com.zhurong.concurrency.advanced.Semaphore;

/**
 Semaphore

 Semaphore是计数信号量。
 Semaphore管理一系列许可证。每个acquire方法阻塞，直到有一个许可证可以获得然后拿走一个许可.
 每个release方法增加一个许可证，这可能会释放一个阻塞的acquire方法。

 然而，其实并没有实际的许可证这个对象，Semaphore只是维持了一个可获得许可证的数量。




 */