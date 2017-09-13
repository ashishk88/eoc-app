package edu.asu.wpcarey.eoc.beans;

public class JobGrowthView {

	private Boolean initiateJobGrowth;
	private Boolean loadMetaData;

	public JobGrowthView() {
		super();
		initiateJobGrowth = Boolean.FALSE;
		loadMetaData = Boolean.FALSE;
	}

	public JobGrowthView(final Boolean initiateJobGrowth, final Boolean loadMetaData) {
		super();
		this.initiateJobGrowth = initiateJobGrowth;
		this.loadMetaData = loadMetaData;
	}

	public Boolean getInitiateJobGrowth() {
		return initiateJobGrowth;
	}

	public Boolean getLoadMetaData() {
		return loadMetaData;
	}

	public void setInitiateJobGrowth(final Boolean initiateJobGrowth) {
		this.initiateJobGrowth = initiateJobGrowth;
	}

	public void setLoadMetaData(final Boolean loadMetaData) {
		this.loadMetaData = loadMetaData;
	}
}
