package com.jordanglassman.fun;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.shared.SharedValue;
import org.apache.curator.retry.ExponentialBackoffRetry;

import static java.util.Objects.isNull;

public class CuratorFun {
	public static void main(String[] args) throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181,localhost:2182,localhost:2183", retryPolicy);
		client.start();

		if(isNull(client.checkExists().forPath("/zk-fun"))) {
			client.create().forPath("/zk-fun", "lol".getBytes());
		}

		SharedValue sharedValue = new SharedValue(client, "/zk-fun2", "lol2".getBytes());
		sharedValue.getListenable().addListener(new SharedValueFun());

//		sharedValue.

	}
}
