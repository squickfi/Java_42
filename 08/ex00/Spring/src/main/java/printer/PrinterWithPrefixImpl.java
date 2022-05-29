package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer _renderer;
    private String _prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        _renderer = renderer;
        _prefix = "";
    }

    @Override
    public void print(String text) {
        _renderer.printString(_prefix + text);
    }

    public void setPrefix(String prefix) {
        _prefix = prefix;
    }
}
