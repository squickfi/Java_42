package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    private PreProcessor _preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        _preProcessor = preProcessor;
    }

    @Override
    public void printString (String text) {
        System.err.println(_preProcessor.preProcess(text));
    }
}
