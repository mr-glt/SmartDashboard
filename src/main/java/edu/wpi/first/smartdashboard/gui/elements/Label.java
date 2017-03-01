package edu.wpi.first.smartdashboard.gui.elements;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.IntegerProperty;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.properties.StringProperty;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Joe Grinstead
 */
public class Label extends StaticWidget {

  public final StringProperty text = new StringProperty(this, "Text", "Label");
  public final MultiProperty horizontal = new MultiProperty(this, "Horizontal Alignment");
  public final MultiProperty vertical = new MultiProperty(this, "Vertical Alignment");
  public final IntegerProperty textSize = new IntegerProperty(this, "Text Size", 12);
  public final MultiProperty textStyle = new MultiProperty(this, "Text Style");

  private JLabel label;

  public Label() {
    horizontal.add("Left", SwingConstants.LEFT);
    horizontal.add("Center", SwingConstants.CENTER);
    horizontal.add("Right", SwingConstants.RIGHT);
    horizontal.setDefault("Center");

    vertical.add("Up", SwingConstants.TOP);
    vertical.add("Center", SwingConstants.CENTER);
    vertical.add("Down", SwingConstants.BOTTOM);
    vertical.setDefault("Center");

    textStyle.add("Bold", Font.BOLD);
    textStyle.add("Italic", Font.ITALIC);
    textStyle.add("Regular", Font.PLAIN);
    textStyle.setDefault("Regular");
  }

  @Override
  public void init() {
    setLayout(new BorderLayout());

    label = new JLabel(text.getValue());

    label.setHorizontalAlignment((Integer) horizontal.getValue());
    label.setVerticalAlignment((Integer) vertical.getValue());
    label.setFont(new Font(Font.SANS_SERIF, (Integer) textStyle.getValue(), textSize.getValue()));

    add(label, BorderLayout.CENTER);
  }

  @Override
  public void propertyChanged(Property property) {
    if (property == text) {
      label.setText(text.getValue());
    } else if (property == horizontal) {
      label.setHorizontalAlignment((Integer) horizontal.getValue());
    } else if (property == vertical) {
      label.setVerticalAlignment((Integer) vertical.getValue());
    } else if (property == textSize) {
      label.setFont(new Font(Font.SANS_SERIF, (Integer) textStyle.getValue(), textSize.getValue()));
    } else if (property == textStyle) {
      label.setFont(new Font(Font.SANS_SERIF, (Integer) textStyle.getValue(), textSize.getValue()));
    }
  }
}
