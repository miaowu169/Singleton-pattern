package com.game.test;

import com.game.domain.Base;

import com.game.domain.Hero;
import com.game.domain.HouYi;
import com.game.domain.LuBanQiHao;

public class BaseTest {
	public static void main(String [] args){
		System.out.println("����Ӣ�ۼ��ϣ�׼���������أ�");
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
		System.out.println("Ӣ��:"+hero.getHeroName()+"�˺�ֵ:"+ hero.getHeroHurt());
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
						System.out.println("Ӣ��"+hero.getHeroName()+"���ڹ������أ�����ʣ������ֵ:"+base.getLife());
					}else {
						base.setDestroy(true);
						System.out.println("�����ѱ�"+hero.getHeroName()+"�ݻ�");	
					}
				}
			}
		}
	}
}
