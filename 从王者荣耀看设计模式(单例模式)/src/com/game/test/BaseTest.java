package com.game.test;

import com.game.domain.Base;

import com.game.domain.Hero;
import com.game.domain.HouYi;
import com.game.domain.LuBanQiHao;

public class BaseTest {
	public static void main(String [] args){
		System.out.println("所有英雄集合，准备攻击基地！");
		new Thread(new Runnable(){
			public void run() {
				Hero hero=new HouYi();
				hero.setHeroHurt(100);
				Base base = Base.getBase();
				destroyBase(hero,base);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				Hero hero=new LuBanQiHao();
				hero.setHeroHurt(80);
				Base base=Base.getBase();
				destroyBase(hero,base);
			}
		}).start();
	}
	
	private static void destroyBase(Hero hero,Base base) {
		System.out.println("英雄:"+hero.getHeroName()+"伤害值:"+ hero.getHeroHurt());
		while(base.getLife()>0) {
			synchronized(base) {
				if(!base.isDestroy()) {
					base.setLife(base.getLife()-hero.getHeroHurt());
					
					try {
						Thread.sleep(500);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					
					if(base.getLife()>0) {
						System.out.println("英雄"+hero.getHeroName()+"正在攻击基地，基地剩余生命值:"+base.getLife());
					}else {
						base.setDestroy(true);
						System.out.println("基地已被"+hero.getHeroName()+"摧毁");	
					}
				}
			}
		}
	}
}
