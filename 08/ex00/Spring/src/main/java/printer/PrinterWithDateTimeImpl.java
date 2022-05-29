package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    private Renderer _renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        _renderer = renderer;
    }

    @Override
    public void print (String text) {
        _renderer.printString(LocalDateTime.now() + " " + text);
    }
}
