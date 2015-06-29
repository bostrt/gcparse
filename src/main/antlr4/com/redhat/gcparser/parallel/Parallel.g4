// 0.051: [GC 528K->336K(10240K), 0.0011200 secs]
// 0.053: [Full GC 288K->246K(10240K), 0.0062090 secs]
// 59.821: [GC [PSYoungGen: 147904K->4783K(148288K)] 907842K->769258K(916288K), 0.2382801 secs] [Times: user=0.31 sys=0.00, real=0.24 secs]
// 60.060: [Full GC [PSYoungGen: 4783K->0K(148288K)] [PSOldGen: 764475K->660316K(768000K)] 769258K->660316K(916288K) [PSPermGen: 1850K->1850K(12288K)], 1.2817061 secs] [Times: user=1.26 sys=0.00, real=1.28 secs]

grammar Parallel;

line     : ( event NEWLINE )* ;
event    : timestamp ': [' phase ' ' youngGenSize oldGenSize size permGenSize ', ' timeTaken ' secs]' timeTakeDetail;

youngGenSize : ('[PSYoungGen: ' size '] ')? ;
oldGenSize   : ('[PSOldGen: ' size '] ')? ;
permGenSize  : (' [PSPermGen: ' size ']')? ;
timeTakeDetail : (' [Times: user=' user ' sys=' sys ', real=' real ' secs]')? ;

user : TIME ;
sys  : TIME ;
real : TIME ;

phase  : PHASE ;
size       : before 'K->' after 'K(' committed 'K)' ;
before     : INT ;
after      : INT ;
committed  : INT ;
timeTaken  : TIME ;
timestamp  : TIME ;

PHASE : ( 'GC' | 'Full GC' ) ;
TIME       : [0-9]+ '.' [0-9]+ ;
INT        : [0-9]+ ;
NEWLINE    : [\r\n]+;
