package com.cyxd.demo.dto;

public class Servicer {

	/* ID */
	private String id;
	/* 员工编号 */
	private String empNo;
	/* 客服编号 */
	private String serNo;
	/* 姓名 */
	private String name;
	/* 昵称 */
	private String nickName;
	/* QQ号 */
	private String qqNo;
	/* 手机号 */
	private String phoneNo;
	/* 状态 */
	private String state;
	/* 分页起始 */
	private String start;
	/* 分页步长 */
	private String cycle;
	/* 查询条件 */
	private String seachWord;
	/* 排序字段 */
	private String orderBy;
	/* 排序类型 */
	private String orderType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo == null ? null : empNo.trim();
	}

	public String getSerNo() {
		return serNo;
	}

	public void setSerNo(String serNo) {
		this.serNo = serNo == null ? null : serNo.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getQqNo() {
		return qqNo;
	}

	public void setQqNo(String qqNo) {
		this.qqNo = qqNo == null ? null : qqNo.trim();
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo == null ? null : phoneNo.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getStart() {
		return start;
	}

	public String getCycle() {
		return cycle;
	}

	public String getSeachWord() {
		return seachWord;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public void setSeachWord(String seachWord) {
		this.seachWord = seachWord;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append(", id=").append(id);
		sb.append(", empNo=").append(empNo);
		sb.append(", serNo=").append(serNo);
		sb.append(", name=").append(name);
		sb.append(", nickName=").append(nickName);
		sb.append(", qqNo=").append(qqNo);
		sb.append(", phoneNo=").append(phoneNo);
		sb.append(", state=").append(state);
		sb.append("]");
		return sb.toString();
	}

	public Servicer() {
		super();
	}
	
	public Servicer(String state) {
		this.state = state;
	}
	
	public Servicer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Servicer(String id, String empNo, String serNo, String name,
			String nickName, String qqNo, String phoneNo, String state) {
		this.id = id;
		this.empNo = empNo;
		this.serNo = serNo;
		this.name = name;
		this.nickName = nickName;
		this.qqNo = qqNo;
		this.phoneNo = phoneNo;
		this.state = state;
	}

	public Servicer(String start, String cycle, String seachWord,
			String orderBy, String orderType, Integer beh) {
		this.start = start;
		this.cycle = cycle;
		this.seachWord = seachWord;
		this.orderBy = orderBy;
		this.orderType = orderType;
	}

}