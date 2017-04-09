package clase;

import java.util.ArrayList;
import java.util.List;

public class InformatiiComanda {

	// care taker
	private List<ComandaMemento> salvari = new ArrayList<ComandaMemento>();

	public void addSalvare(ComandaMemento salvare) {
		this.salvari.add(salvare);
	}

	public ComandaMemento recupereazaUltimaSalvare() {
		if (salvari.size() != 0) {
			ComandaMemento salvare = salvari.get(salvari.size() - 1);
			salvari.remove(salvari.size() - 1);
			return salvare;
		} else
			return new ComandaMemento("");
	}
}
