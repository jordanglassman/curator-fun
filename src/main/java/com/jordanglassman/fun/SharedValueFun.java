package com.jordanglassman.fun;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.shared.SharedValueListener;
import org.apache.curator.framework.recipes.shared.SharedValueReader;
import org.apache.curator.framework.state.ConnectionState;

public class SharedValueFun implements SharedValueListener {
	@Override
	public void valueHasChanged(SharedValueReader sharedValueReader, byte[] bytes) throws Exception {

	}

	@Override
	public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {

	}
}
