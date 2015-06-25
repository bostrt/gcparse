package com.redhat.com.redhat.gcparser.cms;

import com.redhat.gcparser.cms.CMSBaseListener;
import com.redhat.gcparser.cms.CMSLexer;
import com.redhat.gcparser.cms.CMSParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Created by rbost on 6/25/15.
 */
public class CMSTest {

    private class TestCMSListener extends CMSBaseListener {
        private String expectedEvent;
        private double expectedTimestamp;

        public TestCMSListener(String expectedEvent, double expectedTimestamp) {
            this.expectedEvent = expectedEvent;
            this.expectedTimestamp = expectedTimestamp;
        }

        @Override
        public void enterEventType(CMSParser.EventTypeContext ctx) {
            assert expectedEvent.equals(ctx.getText());
        }

        @Override
        public void enterTimestamp(CMSParser.TimestampContext ctx) {
            assert expectedTimestamp == Double.parseDouble(ctx.getText());
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
        walker.walk(new TestCMSListener("CMS-concurrent-mark-start", 0.708), p.line());
    }
}
