package br.com.G0921052e1210325.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.G0921052e1210325.models.PointNumber;

public class BoardBean {

	public List<String> getPoint1() {
		return point1;
	}

	public void setPoint1(List<String> point1) {
		this.point1 = point1;
	}

	private List<String> point1 = new ArrayList<String>();

	public List<String> getPoint2() {
		return point2;
	}

	public void setPoint2(List<String> point2) {
		this.point2 = point2;
	}

	public List<String> getPoint3() {
		return point3;
	}

	public void setPoint3(List<String> point3) {
		this.point3 = point3;
	}

	public List<String> getPoint4() {
		return point4;
	}

	public void setPoint4(List<String> point4) {
		this.point4 = point4;
	}

	public List<String> getPoint5() {
		return point5;
	}

	public void setPoint5(List<String> point5) {
		this.point5 = point5;
	}

	public List<String> getPoint6() {
		return point6;
	}

	public void setPoint6(List<String> point6) {
		this.point6 = point6;
	}

	public List<String> getPoint7() {
		return point7;
	}

	public void setPoint7(List<String> point7) {
		this.point7 = point7;
	}

	public List<String> getPoint8() {
		return point8;
	}

	public void setPoint8(List<String> point8) {
		this.point8 = point8;
	}

	public List<String> getPoint9() {
		return point9;
	}

	public void setPoint9(List<String> point9) {
		this.point9 = point9;
	}

	public List<String> getPoint10() {
		return point10;
	}

	public void setPoint10(List<String> point10) {
		this.point10 = point10;
	}

	public List<String> getPoint11() {
		return point11;
	}

	public void setPoint11(List<String> point11) {
		this.point11 = point11;
	}

	public List<String> getPoint12() {
		return point12;
	}

	public void setPoint12(List<String> point12) {
		this.point12 = point12;
	}

	public List<String> getPoint13() {
		return point13;
	}

	public void setPoint13(List<String> point13) {
		this.point13 = point13;
	}

	public List<String> getPoint14() {
		return point14;
	}

	public void setPoint14(List<String> point14) {
		this.point14 = point14;
	}

	public List<String> getPoint15() {
		return point15;
	}

	public void setPoint15(List<String> point15) {
		this.point15 = point15;
	}

	public List<String> getPoint16() {
		return point16;
	}

	public void setPoint16(List<String> point16) {
		this.point16 = point16;
	}

	public List<String> getPoint17() {
		return point17;
	}

	public void setPoint17(List<String> point17) {
		this.point17 = point17;
	}

	public List<String> getPoint18() {
		return point18;
	}

	public void setPoint18(List<String> point18) {
		this.point18 = point18;
	}

	public List<String> getPoint19() {
		return point19;
	}

	public void setPoint19(List<String> point19) {
		this.point19 = point19;
	}

	public List<String> getPoint20() {
		return point20;
	}

	public void setPoint20(List<String> point20) {
		this.point20 = point20;
	}

	public List<String> getPoint21() {
		return point21;
	}

	public void setPoint21(List<String> point21) {
		this.point21 = point21;
	}

	public List<String> getPoint22() {
		return point22;
	}

	public void setPoint22(List<String> point22) {
		this.point22 = point22;
	}

	public List<String> getPoint23() {
		return point23;
	}

	public void setPoint23(List<String> point23) {
		this.point23 = point23;
	}

	public List<String> getPoint24() {
		return point24;
	}

	public void setPoint24(List<String> point24) {
		this.point24 = point24;
	}

	private List<String> point2 = new ArrayList<String>();
	private List<String> point3 = new ArrayList<String>();
	private List<String> point4 = new ArrayList<String>();
	private List<String> point5 = new ArrayList<String>();
	private List<String> point6 = new ArrayList<String>();
	private List<String> point7 = new ArrayList<String>();
	private List<String> point8 = new ArrayList<String>();
	private List<String> point9 = new ArrayList<String>();
	private List<String> point10 = new ArrayList<String>();
	private List<String> point11 = new ArrayList<String>();
	private List<String> point12 = new ArrayList<String>();
	private List<String> point13 = new ArrayList<String>();
	private List<String> point14 = new ArrayList<String>();
	private List<String> point15 = new ArrayList<String>();
	private List<String> point16 = new ArrayList<String>();
	private List<String> point17 = new ArrayList<String>();
	private List<String> point18 = new ArrayList<String>();
	private List<String> point19 = new ArrayList<String>();
	private List<String> point20 = new ArrayList<String>();
	private List<String> point21 = new ArrayList<String>();
	private List<String> point22 = new ArrayList<String>();
	private List<String> point23 = new ArrayList<String>();
	private List<String> point24 = new ArrayList<String>();

	public BoardBean() {
		init(this.point1);
		init(this.point2);
		init(this.point3);
		init(this.point4);
		init(this.point5);
		init(this.point6);
		init(this.point7);
		init(this.point8);
		init(this.point9);
		init(this.point10);
		init(this.point11);
		init(this.point12);
		init(this.point13);
		init(this.point14);
		init(this.point15);
		init(this.point16);
		init(this.point17);
		init(this.point18);
		init(this.point19);
		init(this.point20);
		init(this.point21);
		init(this.point22);
		init(this.point23);
		init(this.point24);
	}

	public void setFor(PointNumber pointNumber, int quantity, String color) {

		List<String> point = getPoint(pointNumber);

		for (int i = 0; i < quantity; i++) {
			point.set(i, color);
		}
	}

	private List<String> getPoint(PointNumber pointNumber) {

		switch (pointNumber) {
		case Point1:
			return this.point1;
		case Point2:
			return this.point2;
		case Point3:
			return this.point3;
		case Point4:
			return this.point4;
		case Point5:
			return this.point5;
		case Point6:
			return this.point6;
		case Point7:
			return this.point7;
		case Point8:
			return this.point8;
		case Point9:
			return this.point9;
		case Point10:
			return this.point10;
		case Point11:
			return this.point11;
		case Point12:
			return this.point12;
		case Point13:
			return this.point13;
		case Point14:
			return this.point14;
		case Point15:
			return this.point15;
		case Point16:
			return this.point16;
		case Point17:
			return this.point17;
		case Point18:
			return this.point18;
		case Point19:
			return this.point19;
		case Point20:
			return this.point20;
		case Point21:
			return this.point21;
		case Point22:
			return this.point22;
		case Point23:
			return this.point23;
		case Point24:
			return this.point24;
		default:
			return new ArrayList<String>();
		}
	}

	private void init(List<String> p) {
		for (int i = 0; i < 8; i++) {
			p.add("");
		}
	}

}
