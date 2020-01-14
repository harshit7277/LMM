class Employees {
	// global variables of the class
	Manager[] manager;
	Executives[] executive;
	Lead[] lead;

	// constructor has type of data that is required

	Employees(Manager[] managerobject, Executives[] executiveobject, Lead[] leadobject) {
		// TODO Auto-generated constructor stub
		this.manager = managerobject;
		this.executive = executiveobject;
		this.lead = leadobject;
	}

	public Lead[] getS() {
		return lead;
	}

	public void setS(Lead[] s) {
		this.lead = s;
	}

	public Manager[] getB() {
		return manager;
	}

	public void setB(Manager[] b) {
		this.manager = b;
	}

	public Executives[] getC() {
		return executive;
	}

	public void setC(Executives[] c) {
		this.executive = c;
	}

}