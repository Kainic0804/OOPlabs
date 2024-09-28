import javax.swing.JOptionPane;

public class JavaBasic61 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                    "Do want to change your first class ticket?");

        JOptionPane.showMessageDialog(null, "You've chosen: "
                                      + (option == JOptionPane.YES_NO_CANCEL_OPTION ? "Yes" : "No" ));
        System.exit(0);
    }
}
