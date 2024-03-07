/**
 * predifined objects
 */

public enum Colors {
    BLE("#5289a6"),
    RED("#ff0000"),
    GREEN("#008000");

    private String codeColor;

    private Colors(String codeColor){
        this.codeColor = codeColor;

    }

    public String getCodeColor() {
        return codeColor;
    }
}
