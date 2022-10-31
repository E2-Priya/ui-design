package looseCoupling;

public class LooseCouplingStudent {

	private Exam xam;

	public void setXam(Exam xam) {
		this.xam = xam;
	}

	void studentExam() {
		xam.exam();
	}

}
