package renderer;

import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {

    private PreProcessor _preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        _preProcessor = preProcessor;
    }

    @Override
    public void printString(String test) {
        System.out.println(_preProcessor.preProcess(test));
    }
}
