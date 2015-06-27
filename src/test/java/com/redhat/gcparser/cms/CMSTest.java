package com.redhat.gcparser.cms;

import com.redhat.gcparser.model.Phase;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Created by rbost on 6/25/15.
 */
public class CMSTest {

    private class TestCMSListener extends CMSBaseListener {
        private String expectedPhase;
        private double expectedTimestamp;

        public TestCMSListener(Phase expectedPhase, double expectedTimestamp) {
            this.expectedPhase = expectedPhase.getEventTypeName();
            this.expectedTimestamp = expectedTimestamp;
        }
    }

    /**
     * 0.708: [CMS-concurrent-mark-start]
     */
    @Test
    public void concurrentMarkSweep() {
        String line = "0.708: [CMS-concurrent-mark-start]\r\n";
        CMSLexer l = new CMSLexer(new ANTLRInputStream(line));
        CMSParser p = new CMSParser(new CommonTokenStream(l));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TestCMSListener(Phase.CMS_CONCURRENT_MARK_START, 0.708), p.line());
    }
}
