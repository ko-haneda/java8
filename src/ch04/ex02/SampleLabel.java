package ch04.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * TODO テストコード
 * @author haneda
 *
 */
public class SampleLabel {
	private String massage = "";
	private StringProperty property = null;

	public final StringProperty textProperty() {
		if (property == null) {
			property = new SimpleStringProperty(massage);
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
