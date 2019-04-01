package com.derun.jczb.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeMenu {

	private Integer menuCode;
	private String menuName;
	private String menuAlinks;
	private String menuParent;	
	private String level;
	private Set<Userbaseinfo> userset = new HashSet<Userbaseinfo>();
	private List<TreeMenu> menuList = new ArrayList<TreeMenu>();// 子菜单集合
	
	public List<TreeMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<TreeMenu> menuList) {
		this.menuList = menuList;
	}


	public Set<Userbaseinfo> getUserset() {
		return userset;
	}

	public void setUserset(Set<Userbaseinfo> userset) {
		this.userset = userset;
	}

	public String getMenuAlinks() {
		return menuAlinks;
	}

	public void setMenuAlinks(String menuAlinks) {
		this.menuAlinks = menuAlinks;
	}

	public Integer getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(Integer menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
