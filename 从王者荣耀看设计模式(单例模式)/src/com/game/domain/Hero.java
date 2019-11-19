package com.game.domain;

import com.game.skill.ISkill;

public abstract class Hero {
	private String heroName;
	private ISkill iskill;
	public abstract void display();
	private int heroHurt;
	public abstract void normalAttack();
	
	public void skill() {
		iskill.useSkill();
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public ISkill getIskill() {
		return iskill;
	}

	public void setIskill(ISkill iskill) {
		this.iskill = iskill;
	}

	public void setHeroHurt(int heroHurt) {
		this.heroHurt = heroHurt;
	}

	public int getHeroHurt() {
		// TODO Auto-generated method stub
		return heroHurt;
	}
	
	
}
