package ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * TODO ２問目との違いがよくわからない。
 * @author haneda
 *
 */
public class SampleLabel {
	private String massage = null;
	private StringProperty property = null;

	public final StringProperty textProperty() {
		if (property == null) {
			if(massage == null)property = new SimpleStringProperty("");
			else				property = new SimpleStringProperty(massage);
		}
		return property;
	}

	public final void setText(String massage) {
		this.massage = massage;
		if (property != null) {
			property.set(massage);
		}
	}

	public final String getText() {
		return massage;
	}
}
