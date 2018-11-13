package com.cx.mini.boot.kit;

import java.util.Timer;
import java.util.TimerTask;

public class Timerest {

	public static void main(String[] args) {
		// Timer执行调度方法, TimerTask调度执行体
		new Timer().schedule(new TimerTask() {	// 内部类, 重写run方法(方法执行行为)
			@Override
			public void run() {					// 执行行为
				System.out.println(111111111);
			}
		}, 0, 1000);
	}

}
