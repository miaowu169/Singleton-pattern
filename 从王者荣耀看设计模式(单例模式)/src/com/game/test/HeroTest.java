package com.game.test;

import com.game.domain.Hero;
import com.game.domain.HouYi;
import com.game.skill.impl.JiPao;

public class HeroTest {
	public static void main(String [] args) {
		Hero hero = new HouYi();
		System.out.println("Ӣ��:"+hero.getHeroName()+",���ҽ���:");
		hero.display();
		hero.setIskill(new JiPao());
		
		System.out.println("��Ϸ��ʼ,������׼����");
		
		hero.normalAttack();
		hero.skill();
	}
}
