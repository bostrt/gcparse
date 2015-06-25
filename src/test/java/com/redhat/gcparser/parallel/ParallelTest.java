package com.redhat.gcparser.parallel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Created by rbost on 6/25/15.
 */
public class ParallelTest {

    private class TestListener extends ParallelBaseListener {
        @Override
        public void enterPhase(ParallelParser.PhaseContext ctx) {
        }

        @Override
        public void enterPermGenSize(ParallelParser.PermGenSizeContext ctx) {
        }
    }

    @Test
    public void minorGCTest() {
        String line = "0.051: [GC 528K->336K(10240K), 0.0011200 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(), p.line());
    }

    @Test
    public void minorGCDetailsTest() {
        String line = "59.821: [GC [PSYoungGen: 147904K->4783K(148288K)] 907842K->769258K(916288K), 0.2382801 secs] [Times: user=0.31 sys=0.00, real=0.24 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(), p.line());
    }

    @Test
    public void fullGCTest() {
        String line = "0.053: [Full GC 288K->246K(10240K), 0.0062090 secs]\n";
        ParallelLexer l = new ParallelLexer(new ANTLRInputStream(line));
        ParallelParser p = new ParallelParser(new CommonTokenStream(l));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestListener(), p.line());
    }
}
