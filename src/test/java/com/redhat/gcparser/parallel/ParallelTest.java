package com.redhat.gcparser.parallel;

import com.redhat.gcparser.model.ParallelEvent;
import com.redhat.gcparser.model.Size;
import com.redhat.gcparser.model.Times;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rbost on 6/25/15.
 */
public class ParallelTest {

    private static final double FUZZ = 0.001;

    static class TestListener extends ParallelBaseListener {

        interface CompletionCallback {
            public void onComplete(ParallelEvent event);
        }

        private ParallelEvent event;
        private CompletionCallback callback;

        public TestListener(CompletionCallback callback) {
            this.callback = callback;
        }

        @Override
        public void enterEvent(ParallelParser.EventContext ctx) {
            event = new ParallelEvent();
        }

        @Override
        public void enterSize(ParallelParser.SizeContext ctx) {
            if (ctx.before() == null || ctx.after() == null || ctx.committed() == null) {
                return;
            }

            int before = Integer.parseInt(ctx.before().getText());
            int after = Integer.parseInt(ctx.after().getText());
            int committed = Integer.parseInt(ctx.committed().getText());
            Size size = new Size(before, after, committed);
            event.setSize(size);
        }

        @Override
        public void enterTimeTakeDetail(ParallelParser.TimeTakeDetailContext ctx) {
            if (ctx.real() == null || ctx.sys() == null || ctx.user() == null) {
                return;
            }

            double user = Double.valueOf(ctx.user().getText());
            double sys  = Double.valueOf(ctx.sys().getText());
            double real = Double.valueOf(ctx.real().getText());

            Times times = new Times(user, sys, real);
            event.setTimes(times);
        }

        @Override
        public void exitEvent(ParallelParser.EventContext ctx) {
            callback.onComplete(event);
        }
    }

    @Test
    public void minorGCTest() {
        String line = "0.051: [GC 528K->336K(10240K), 0.0011200 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));

        TestListener.CompletionCallback callback = new TestListener.CompletionCallback() {
            public void onComplete(ParallelEvent event) {

            }
        };

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(callback), p.line());
    }

    @Test
    public void minorGCDetailsTest() {
        String line = "59.821: [GC [PSYoungGen: 147904K->4783K(148288K)] 907842K->769258K(916288K), 0.2382801 secs] [Times: user=0.31 sys=0.00, real=0.24 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));

        TestListener.CompletionCallback callback = new TestListener.CompletionCallback() {
            public void onComplete(ParallelEvent event) {
                Times expectedTimes = new Times(0.31, 0.00, 0.24);
                Times actualTimes = event.getTimes();
                assertEquals(expectedTimes.getReal(), actualTimes.getReal(), FUZZ);
                assertEquals(expectedTimes.getReal(), actualTimes.getReal(), FUZZ);
                assertEquals(expectedTimes.getReal(), actualTimes.getReal(), FUZZ);
            }
        };

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(callback), p.line());
    }

    @Test
    public void fullGCTest() {
        String line = "0.053: [Full GC 288K->246K(10240K), 0.0062090 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));

        TestListener.CompletionCallback callback = new TestListener.CompletionCallback() {
            public void onComplete(ParallelEvent event) {
                System.out.println(event.getSize());
            }
        };

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(callback), p.line());
    }
}
