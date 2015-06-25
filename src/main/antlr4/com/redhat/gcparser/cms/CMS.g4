grammar CMS;

// https://github.com/chewiebug/GCViewer/blob/develop/src/test/resources/openjdk/SampleSun1_6_0CMS.txt
// 0.294: [GC 0.294: [ParNew: 104960K->13042K(118016K), 0.0284337 secs] 104960K->34501K(249088K), 0.0285898 secs] [Times: user=0.01 sys=0.09, real=0.03 secs]
// 0.708: [GC [1 CMS-initial-mark: 91890K(131072K)] 109176K(249088K), 0.0004006 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
// 0.708: [CMS-concurrent-mark-start]
// 0.714: [CMS-concurrent-mark: 0.006/0.006 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
// 0.714: [CMS-concurrent-preclean-start]
// 0.715: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
// 0.769: [GC 0.769: [ParNew: 118006K->118006K(118016K), 0.0000176 secs]0.769: [CMS0.769: [CMS-concurrent-abortable-preclean: 0.001/0.055 secs] [Times: user=0.02 sys=0.00, real=0.06 secs]
// (concurrent mode failure): 91890K->20323K(131072K), 0.0186232 secs] 209896K->20323K(249088K), [CMS Perm : 2561K->2560K(21248K)], 0.0187293 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
// 0.903: [GC [1 CMS-initial-mark: 65665K(131072K)] 80841K(249088K), 0.0002073 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
// 0.903: [CMS-concurrent-mark-start]
// 0.909: [CMS-concurrent-mark: 0.006/0.006 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
// 0.909: [CMS-concurrent-preclean-start]
// 0.910: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
// 0.910: [CMS-concurrent-abortable-preclean-start]
// 1.166: [GC 1.166: [ParNew: 108749K->13032K(118016K), 0.0131036 secs] 140046K->61145K(249088K), 0.0131651 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
// 1.593: [GC[YG occupancy: 15176 K (118016 K)]1.593: [Rescan (parallel) , 0.0003847 secs]1.594: [weak refs processing, 0.0000057 secs] [1 CMS-remark: 115034K(131072K)] 130210K(249088K), 0.0005792 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//
line       : (event NEWLINE)* ;
event      : timestamp ': [' eventType ']';
eventType   : EVENT_TYPE ;
timestamp  : TIME ;

EVENT_TYPE : ( 'GC' | 'CMS-concurrent-mark-start' | 'CMS-concurrent-preclean-start' );
TIME       : [0-9]+ '.' [0-9]+ ;
NEWLINE    : [\r\n]+;
