package com.game.test;

import com.game.domain.Hero;
import com.game.domain.HouYi;
import com.game.skill.impl.JiPao;

public class HeroTest {
	public static void main(String [] args) {
		Hero hero = new HouYi();
		System.out.println("英雄:"+hero.getHeroName()+",自我介绍:");
		hero.display();
		hero.setIskill(new JiPao());
		
		System.out.println("游戏开始,请做好准备！");
		
		hero.normalAttack();
		hero.skill();
	}
}
