\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj1: x1#0 + x2#1 + x3#2 + x4#3 + x5#4 + x6#5 + x7#6 + x8#7 + x9#8 + x10#9
       + x11#10 + x12#11 + x13#12 + x14#13 + x15#14 + x16#15 + x17#16 + x18#17
       + x19#18 + x20#19
Subject To
 vincolo_xipxj_ge1#0:           x1#0 + x2#1 >= 1
 __vincolo_yijmximxjgem1#1:     - x1#0 - x2#1 + y#20 >= -1
 __vincolo_yijmxile0#2:         - x1#0 + y#20 <= 0
 __vincolo_yijmxjle0#3:         - x2#1 + y#20 <= 0
 vincolo_fijmnayijle0#4:        - 20 y#20 + f#21 <= 0
 vincolo_fjimnayijle0#5:        - 20 y#20 + f#22 <= 0
 vincolo_xipxj_ge1#6:           x2#1 + x3#2 >= 1
 __vincolo_yijmximxjgem1#7:     - x2#1 - x3#2 + y#23 >= -1
 __vincolo_yijmxile0#8:         - x2#1 + y#23 <= 0
 __vincolo_yijmxjle0#9:         - x3#2 + y#23 <= 0
 vincolo_fijmnayijle0#10:       - 20 y#23 + f#24 <= 0
 vincolo_fjimnayijle0#11:       - 20 y#23 + f#25 <= 0
 vincolo_xipxj_ge1#12:          x3#2 + x4#3 >= 1
 __vincolo_yijmximxjgem1#13:    - x3#2 - x4#3 + y#26 >= -1
 __vincolo_yijmxile0#14:        - x3#2 + y#26 <= 0
 __vincolo_yijmxjle0#15:        - x4#3 + y#26 <= 0
 vincolo_fijmnayijle0#16:       - 20 y#26 + f#27 <= 0
 vincolo_fjimnayijle0#17:       - 20 y#26 + f#28 <= 0
 vincolo_xipxj_ge1#18:          x4#3 + x5#4 >= 1
 __vincolo_yijmximxjgem1#19:    - x4#3 - x5#4 + y#29 >= -1
 __vincolo_yijmxile0#20:        - x4#3 + y#29 <= 0
 __vincolo_yijmxjle0#21:        - x5#4 + y#29 <= 0
 vincolo_fijmnayijle0#22:       - 20 y#29 + f#30 <= 0
 vincolo_fjimnayijle0#23:       - 20 y#29 + f#31 <= 0
 vincolo_xipxj_ge1#24:          x5#4 + x6#5 >= 1
 __vincolo_yijmximxjgem1#25:    - x5#4 - x6#5 + y#32 >= -1
 __vincolo_yijmxile0#26:        - x5#4 + y#32 <= 0
 __vincolo_yijmxjle0#27:        - x6#5 + y#32 <= 0
 vincolo_fijmnayijle0#28:       - 20 y#32 + f#33 <= 0
 vincolo_fjimnayijle0#29:       - 20 y#32 + f#34 <= 0
 vincolo_xipxj_ge1#30:          x6#5 + x7#6 >= 1
 __vincolo_yijmximxjgem1#31:    - x6#5 - x7#6 + y#35 >= -1
 __vincolo_yijmxile0#32:        - x6#5 + y#35 <= 0
 __vincolo_yijmxjle0#33:        - x7#6 + y#35 <= 0
 vincolo_fijmnayijle0#34:       - 20 y#35 + f#36 <= 0
 vincolo_fjimnayijle0#35:       - 20 y#35 + f#37 <= 0
 vincolo_xipxj_ge1#36:          x7#6 + x8#7 >= 1
 __vincolo_yijmximxjgem1#37:    - x7#6 - x8#7 + y#38 >= -1
 __vincolo_yijmxile0#38:        - x7#6 + y#38 <= 0
 __vincolo_yijmxjle0#39:        - x8#7 + y#38 <= 0
 vincolo_fijmnayijle0#40:       - 20 y#38 + f#39 <= 0
 vincolo_fjimnayijle0#41:       - 20 y#38 + f#40 <= 0
 vincolo_xipxj_ge1#42:          x8#7 + x9#8 >= 1
 __vincolo_yijmximxjgem1#43:    - x8#7 - x9#8 + y#41 >= -1
 __vincolo_yijmxile0#44:        - x8#7 + y#41 <= 0
 __vincolo_yijmxjle0#45:        - x9#8 + y#41 <= 0
 vincolo_fijmnayijle0#46:       - 20 y#41 + f#42 <= 0
 vincolo_fjimnayijle0#47:       - 20 y#41 + f#43 <= 0
 vincolo_xipxj_ge1#48:          x9#8 + x10#9 >= 1
 __vincolo_yijmximxjgem1#49:    - x9#8 - x10#9 + y#44 >= -1
 __vincolo_yijmxile0#50:        - x9#8 + y#44 <= 0
 __vincolo_yijmxjle0#51:        - x10#9 + y#44 <= 0
 vincolo_fijmnayijle0#52:       - 20 y#44 + f#45 <= 0
 vincolo_fjimnayijle0#53:       - 20 y#44 + f#46 <= 0
 vincolo_xipxj_ge1#54:          x10#9 + x11#10 >= 1
 __vincolo_yijmximxjgem1#55:    - x10#9 - x11#10 + y#47 >= -1
 __vincolo_yijmxile0#56:        - x10#9 + y#47 <= 0
 __vincolo_yijmxjle0#57:        - x11#10 + y#47 <= 0
 vincolo_fijmnayijle0#58:       - 20 y#47 + f#48 <= 0
 vincolo_fjimnayijle0#59:       - 20 y#47 + f#49 <= 0
 vincolo_xipxj_ge1#60:          x11#10 + x12#11 >= 1
 __vincolo_yijmximxjgem1#61:    - x11#10 - x12#11 + y#50 >= -1
 __vincolo_yijmxile0#62:        - x11#10 + y#50 <= 0
 __vincolo_yijmxjle0#63:        - x12#11 + y#50 <= 0
 vincolo_fijmnayijle0#64:       - 20 y#50 + f#51 <= 0
 vincolo_fjimnayijle0#65:       - 20 y#50 + f#52 <= 0
 vincolo_xipxj_ge1#66:          x12#11 + x13#12 >= 1
 __vincolo_yijmximxjgem1#67:    - x12#11 - x13#12 + y#53 >= -1
 __vincolo_yijmxile0#68:        - x12#11 + y#53 <= 0
 __vincolo_yijmxjle0#69:        - x13#12 + y#53 <= 0
 vincolo_fijmnayijle0#70:       - 20 y#53 + f#54 <= 0
 vincolo_fjimnayijle0#71:       - 20 y#53 + f#55 <= 0
 vincolo_xipxj_ge1#72:          x13#12 + x14#13 >= 1
 __vincolo_yijmximxjgem1#73:    - x13#12 - x14#13 + y#56 >= -1
 __vincolo_yijmxile0#74:        - x13#12 + y#56 <= 0
 __vincolo_yijmxjle0#75:        - x14#13 + y#56 <= 0
 vincolo_fijmnayijle0#76:       - 20 y#56 + f#57 <= 0
 vincolo_fjimnayijle0#77:       - 20 y#56 + f#58 <= 0
 vincolo_xipxj_ge1#78:          x14#13 + x15#14 >= 1
 __vincolo_yijmximxjgem1#79:    - x14#13 - x15#14 + y#59 >= -1
 __vincolo_yijmxile0#80:        - x14#13 + y#59 <= 0
 __vincolo_yijmxjle0#81:        - x15#14 + y#59 <= 0
 vincolo_fijmnayijle0#82:       - 20 y#59 + f#60 <= 0
 vincolo_fjimnayijle0#83:       - 20 y#59 + f#61 <= 0
 vincolo_xipxj_ge1#84:          x15#14 + x16#15 >= 1
 __vincolo_yijmximxjgem1#85:    - x15#14 - x16#15 + y#62 >= -1
 __vincolo_yijmxile0#86:        - x15#14 + y#62 <= 0
 __vincolo_yijmxjle0#87:        - x16#15 + y#62 <= 0
 vincolo_fijmnayijle0#88:       - 20 y#62 + f#63 <= 0
 vincolo_fjimnayijle0#89:       - 20 y#62 + f#64 <= 0
 vincolo_xipxj_ge1#90:          x16#15 + x17#16 >= 1
 __vincolo_yijmximxjgem1#91:    - x16#15 - x17#16 + y#65 >= -1
 __vincolo_yijmxile0#92:        - x16#15 + y#65 <= 0
 __vincolo_yijmxjle0#93:        - x17#16 + y#65 <= 0
 vincolo_fijmnayijle0#94:       - 20 y#65 + f#66 <= 0
 vincolo_fjimnayijle0#95:       - 20 y#65 + f#67 <= 0
 vincolo_xipxj_ge1#96:          x17#16 + x18#17 >= 1
 __vincolo_yijmximxjgem1#97:    - x17#16 - x18#17 + y#68 >= -1
 __vincolo_yijmxile0#98:        - x17#16 + y#68 <= 0
 __vincolo_yijmxjle0#99:        - x18#17 + y#68 <= 0
 vincolo_fijmnayijle0#100:      - 20 y#68 + f#69 <= 0
 vincolo_fjimnayijle0#101:      - 20 y#68 + f#70 <= 0
 vincolo_xipxj_ge1#102:         x18#17 + x19#18 >= 1
 __vincolo_yijmximxjgem1#103:   - x18#17 - x19#18 + y#71 >= -1
 __vincolo_yijmxile0#104:       - x18#17 + y#71 <= 0
 __vincolo_yijmxjle0#105:       - x19#18 + y#71 <= 0
 vincolo_fijmnayijle0#106:      - 20 y#71 + f#72 <= 0
 vincolo_fjimnayijle0#107:      - 20 y#71 + f#73 <= 0
 vincolo_xipxj_ge1#108:         x19#18 + x20#19 >= 1
 __vincolo_yijmximxjgem1#109:   - x19#18 - x20#19 + y#74 >= -1
 __vincolo_yijmxile0#110:       - x19#18 + y#74 <= 0
 __vincolo_yijmxjle0#111:       - x20#19 + y#74 <= 0
 vincolo_fijmnayijle0#112:      - 20 y#74 + f#75 <= 0
 vincolo_fjimnayijle0#113:      - 20 y#74 + f#76 <= 0
 vincolo_xipxj_ge1#114:         x18#17 + x20#19 >= 1
 __vincolo_yijmximxjgem1#115:   - x18#17 - x20#19 + y#77 >= -1
 __vincolo_yijmxile0#116:       - x20#19 + y#77 <= 0
 __vincolo_yijmxjle0#117:       - x18#17 + y#77 <= 0
 vincolo_fijmnayijle0#118:      - 20 y#77 + f#78 <= 0
 vincolo_fjimnayijle0#119:      - 20 y#77 + f#79 <= 0
 __vincolo_timxile0#120:        - x1#0 + t#80 <= 0
 __vincolo_f0imnatile0#121:     - 20 t#80 + f#81 <= 0
 vincolo_timtjmxigem1#122:      - x1#0 + t#80 - t#82 >= -1
 vincolo_timtjmxigem1#123:      - x1#0 + t#80 - t#83 >= -1
 vincolo_timtjmxigem1#124:      - x1#0 + t#80 - t#84 >= -1
 vincolo_timtjmxigem1#125:      - x1#0 + t#80 - t#85 >= -1
 vincolo_timtjmxigem1#126:      - x1#0 + t#80 - t#86 >= -1
 vincolo_timtjmxigem1#127:      - x1#0 + t#80 - t#87 >= -1
 vincolo_timtjmxigem1#128:      - x1#0 + t#80 - t#88 >= -1
 vincolo_timtjmxigem1#129:      - x1#0 + t#80 - t#89 >= -1
 vincolo_timtjmxigem1#130:      - x1#0 + t#80 - t#90 >= -1
 vincolo_timtjmxigem1#131:      - x1#0 + t#80 - t#91 >= -1
 vincolo_timtjmxigem1#132:      - x1#0 + t#80 - t#92 >= -1
 vincolo_timtjmxigem1#133:      - x1#0 + t#80 - t#93 >= -1
 vincolo_timtjmxigem1#134:      - x1#0 + t#80 - t#94 >= -1
 vincolo_timtjmxigem1#135:      - x1#0 + t#80 - t#95 >= -1
 vincolo_timtjmxigem1#136:      - x1#0 + t#80 - t#96 >= -1
 vincolo_timtjmxigem1#137:      - x1#0 + t#80 - t#97 >= -1
 vincolo_timtjmxigem1#138:      - x1#0 + t#80 - t#98 >= -1
 vincolo_timtjmxigem1#139:      - x1#0 + t#80 - t#99 >= -1
 vincolo_timtjmxigem1#140:      - x1#0 + t#80 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#141:      x1#0 + f#21 - f#22 - f#81  = 0
 __vincolo_timxile0#142:        - x2#1 + t#82 <= 0
 __vincolo_f0imnatile0#143:     - 20 t#82 + f#101 <= 0
 vincolo_timtjmxigem1#144:      - x2#1 + t#82 - t#83 >= -1
 vincolo_timtjmxigem1#145:      - x2#1 + t#82 - t#84 >= -1
 vincolo_timtjmxigem1#146:      - x2#1 + t#82 - t#85 >= -1
 vincolo_timtjmxigem1#147:      - x2#1 + t#82 - t#86 >= -1
 vincolo_timtjmxigem1#148:      - x2#1 + t#82 - t#87 >= -1
 vincolo_timtjmxigem1#149:      - x2#1 + t#82 - t#88 >= -1
 vincolo_timtjmxigem1#150:      - x2#1 + t#82 - t#89 >= -1
 vincolo_timtjmxigem1#151:      - x2#1 + t#82 - t#90 >= -1
 vincolo_timtjmxigem1#152:      - x2#1 + t#82 - t#91 >= -1
 vincolo_timtjmxigem1#153:      - x2#1 + t#82 - t#92 >= -1
 vincolo_timtjmxigem1#154:      - x2#1 + t#82 - t#93 >= -1
 vincolo_timtjmxigem1#155:      - x2#1 + t#82 - t#94 >= -1
 vincolo_timtjmxigem1#156:      - x2#1 + t#82 - t#95 >= -1
 vincolo_timtjmxigem1#157:      - x2#1 + t#82 - t#96 >= -1
 vincolo_timtjmxigem1#158:      - x2#1 + t#82 - t#97 >= -1
 vincolo_timtjmxigem1#159:      - x2#1 + t#82 - t#98 >= -1
 vincolo_timtjmxigem1#160:      - x2#1 + t#82 - t#99 >= -1
 vincolo_timtjmxigem1#161:      - x2#1 + t#82 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#162:      x2#1 - f#21 + f#22 + f#24 - f#25 - f#101  = 0
 __vincolo_timxile0#163:        - x3#2 + t#83 <= 0
 __vincolo_f0imnatile0#164:     - 20 t#83 + f#102 <= 0
 vincolo_timtjmxigem1#165:      - x3#2 + t#83 - t#84 >= -1
 vincolo_timtjmxigem1#166:      - x3#2 + t#83 - t#85 >= -1
 vincolo_timtjmxigem1#167:      - x3#2 + t#83 - t#86 >= -1
 vincolo_timtjmxigem1#168:      - x3#2 + t#83 - t#87 >= -1
 vincolo_timtjmxigem1#169:      - x3#2 + t#83 - t#88 >= -1
 vincolo_timtjmxigem1#170:      - x3#2 + t#83 - t#89 >= -1
 vincolo_timtjmxigem1#171:      - x3#2 + t#83 - t#90 >= -1
 vincolo_timtjmxigem1#172:      - x3#2 + t#83 - t#91 >= -1
 vincolo_timtjmxigem1#173:      - x3#2 + t#83 - t#92 >= -1
 vincolo_timtjmxigem1#174:      - x3#2 + t#83 - t#93 >= -1
 vincolo_timtjmxigem1#175:      - x3#2 + t#83 - t#94 >= -1
 vincolo_timtjmxigem1#176:      - x3#2 + t#83 - t#95 >= -1
 vincolo_timtjmxigem1#177:      - x3#2 + t#83 - t#96 >= -1
 vincolo_timtjmxigem1#178:      - x3#2 + t#83 - t#97 >= -1
 vincolo_timtjmxigem1#179:      - x3#2 + t#83 - t#98 >= -1
 vincolo_timtjmxigem1#180:      - x3#2 + t#83 - t#99 >= -1
 vincolo_timtjmxigem1#181:      - x3#2 + t#83 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#182:      x3#2 - f#24 + f#25 + f#27 - f#28 - f#102  = 0
 __vincolo_timxile0#183:        - x4#3 + t#84 <= 0
 __vincolo_f0imnatile0#184:     - 20 t#84 + f#103 <= 0
 vincolo_timtjmxigem1#185:      - x4#3 + t#84 - t#85 >= -1
 vincolo_timtjmxigem1#186:      - x4#3 + t#84 - t#86 >= -1
 vincolo_timtjmxigem1#187:      - x4#3 + t#84 - t#87 >= -1
 vincolo_timtjmxigem1#188:      - x4#3 + t#84 - t#88 >= -1
 vincolo_timtjmxigem1#189:      - x4#3 + t#84 - t#89 >= -1
 vincolo_timtjmxigem1#190:      - x4#3 + t#84 - t#90 >= -1
 vincolo_timtjmxigem1#191:      - x4#3 + t#84 - t#91 >= -1
 vincolo_timtjmxigem1#192:      - x4#3 + t#84 - t#92 >= -1
 vincolo_timtjmxigem1#193:      - x4#3 + t#84 - t#93 >= -1
 vincolo_timtjmxigem1#194:      - x4#3 + t#84 - t#94 >= -1
 vincolo_timtjmxigem1#195:      - x4#3 + t#84 - t#95 >= -1
 vincolo_timtjmxigem1#196:      - x4#3 + t#84 - t#96 >= -1
 vincolo_timtjmxigem1#197:      - x4#3 + t#84 - t#97 >= -1
 vincolo_timtjmxigem1#198:      - x4#3 + t#84 - t#98 >= -1
 vincolo_timtjmxigem1#199:      - x4#3 + t#84 - t#99 >= -1
 vincolo_timtjmxigem1#200:      - x4#3 + t#84 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#201:      x4#3 - f#27 + f#28 + f#30 - f#31 - f#103  = 0
 __vincolo_timxile0#202:        - x5#4 + t#85 <= 0
 __vincolo_f0imnatile0#203:     - 20 t#85 + f#104 <= 0
 vincolo_timtjmxigem1#204:      - x5#4 + t#85 - t#86 >= -1
 vincolo_timtjmxigem1#205:      - x5#4 + t#85 - t#87 >= -1
 vincolo_timtjmxigem1#206:      - x5#4 + t#85 - t#88 >= -1
 vincolo_timtjmxigem1#207:      - x5#4 + t#85 - t#89 >= -1
 vincolo_timtjmxigem1#208:      - x5#4 + t#85 - t#90 >= -1
 vincolo_timtjmxigem1#209:      - x5#4 + t#85 - t#91 >= -1
 vincolo_timtjmxigem1#210:      - x5#4 + t#85 - t#92 >= -1
 vincolo_timtjmxigem1#211:      - x5#4 + t#85 - t#93 >= -1
 vincolo_timtjmxigem1#212:      - x5#4 + t#85 - t#94 >= -1
 vincolo_timtjmxigem1#213:      - x5#4 + t#85 - t#95 >= -1
 vincolo_timtjmxigem1#214:      - x5#4 + t#85 - t#96 >= -1
 vincolo_timtjmxigem1#215:      - x5#4 + t#85 - t#97 >= -1
 vincolo_timtjmxigem1#216:      - x5#4 + t#85 - t#98 >= -1
 vincolo_timtjmxigem1#217:      - x5#4 + t#85 - t#99 >= -1
 vincolo_timtjmxigem1#218:      - x5#4 + t#85 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#219:      x5#4 - f#30 + f#31 + f#33 - f#34 - f#104  = 0
 __vincolo_timxile0#220:        - x6#5 + t#86 <= 0
 __vincolo_f0imnatile0#221:     - 20 t#86 + f#105 <= 0
 vincolo_timtjmxigem1#222:      - x6#5 + t#86 - t#87 >= -1
 vincolo_timtjmxigem1#223:      - x6#5 + t#86 - t#88 >= -1
 vincolo_timtjmxigem1#224:      - x6#5 + t#86 - t#89 >= -1
 vincolo_timtjmxigem1#225:      - x6#5 + t#86 - t#90 >= -1
 vincolo_timtjmxigem1#226:      - x6#5 + t#86 - t#91 >= -1
 vincolo_timtjmxigem1#227:      - x6#5 + t#86 - t#92 >= -1
 vincolo_timtjmxigem1#228:      - x6#5 + t#86 - t#93 >= -1
 vincolo_timtjmxigem1#229:      - x6#5 + t#86 - t#94 >= -1
 vincolo_timtjmxigem1#230:      - x6#5 + t#86 - t#95 >= -1
 vincolo_timtjmxigem1#231:      - x6#5 + t#86 - t#96 >= -1
 vincolo_timtjmxigem1#232:      - x6#5 + t#86 - t#97 >= -1
 vincolo_timtjmxigem1#233:      - x6#5 + t#86 - t#98 >= -1
 vincolo_timtjmxigem1#234:      - x6#5 + t#86 - t#99 >= -1
 vincolo_timtjmxigem1#235:      - x6#5 + t#86 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#236:      x6#5 - f#33 + f#34 + f#36 - f#37 - f#105  = 0
 __vincolo_timxile0#237:        - x7#6 + t#87 <= 0
 __vincolo_f0imnatile0#238:     - 20 t#87 + f#106 <= 0
 vincolo_timtjmxigem1#239:      - x7#6 + t#87 - t#88 >= -1
 vincolo_timtjmxigem1#240:      - x7#6 + t#87 - t#89 >= -1
 vincolo_timtjmxigem1#241:      - x7#6 + t#87 - t#90 >= -1
 vincolo_timtjmxigem1#242:      - x7#6 + t#87 - t#91 >= -1
 vincolo_timtjmxigem1#243:      - x7#6 + t#87 - t#92 >= -1
 vincolo_timtjmxigem1#244:      - x7#6 + t#87 - t#93 >= -1
 vincolo_timtjmxigem1#245:      - x7#6 + t#87 - t#94 >= -1
 vincolo_timtjmxigem1#246:      - x7#6 + t#87 - t#95 >= -1
 vincolo_timtjmxigem1#247:      - x7#6 + t#87 - t#96 >= -1
 vincolo_timtjmxigem1#248:      - x7#6 + t#87 - t#97 >= -1
 vincolo_timtjmxigem1#249:      - x7#6 + t#87 - t#98 >= -1
 vincolo_timtjmxigem1#250:      - x7#6 + t#87 - t#99 >= -1
 vincolo_timtjmxigem1#251:      - x7#6 + t#87 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#252:      x7#6 - f#36 + f#37 + f#39 - f#40 - f#106  = 0
 __vincolo_timxile0#253:        - x8#7 + t#88 <= 0
 __vincolo_f0imnatile0#254:     - 20 t#88 + f#107 <= 0
 vincolo_timtjmxigem1#255:      - x8#7 + t#88 - t#89 >= -1
 vincolo_timtjmxigem1#256:      - x8#7 + t#88 - t#90 >= -1
 vincolo_timtjmxigem1#257:      - x8#7 + t#88 - t#91 >= -1
 vincolo_timtjmxigem1#258:      - x8#7 + t#88 - t#92 >= -1
 vincolo_timtjmxigem1#259:      - x8#7 + t#88 - t#93 >= -1
 vincolo_timtjmxigem1#260:      - x8#7 + t#88 - t#94 >= -1
 vincolo_timtjmxigem1#261:      - x8#7 + t#88 - t#95 >= -1
 vincolo_timtjmxigem1#262:      - x8#7 + t#88 - t#96 >= -1
 vincolo_timtjmxigem1#263:      - x8#7 + t#88 - t#97 >= -1
 vincolo_timtjmxigem1#264:      - x8#7 + t#88 - t#98 >= -1
 vincolo_timtjmxigem1#265:      - x8#7 + t#88 - t#99 >= -1
 vincolo_timtjmxigem1#266:      - x8#7 + t#88 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#267:      x8#7 - f#39 + f#40 + f#42 - f#43 - f#107  = 0
 __vincolo_timxile0#268:        - x9#8 + t#89 <= 0
 __vincolo_f0imnatile0#269:     - 20 t#89 + f#108 <= 0
 vincolo_timtjmxigem1#270:      - x9#8 + t#89 - t#90 >= -1
 vincolo_timtjmxigem1#271:      - x9#8 + t#89 - t#91 >= -1
 vincolo_timtjmxigem1#272:      - x9#8 + t#89 - t#92 >= -1
 vincolo_timtjmxigem1#273:      - x9#8 + t#89 - t#93 >= -1
 vincolo_timtjmxigem1#274:      - x9#8 + t#89 - t#94 >= -1
 vincolo_timtjmxigem1#275:      - x9#8 + t#89 - t#95 >= -1
 vincolo_timtjmxigem1#276:      - x9#8 + t#89 - t#96 >= -1
 vincolo_timtjmxigem1#277:      - x9#8 + t#89 - t#97 >= -1
 vincolo_timtjmxigem1#278:      - x9#8 + t#89 - t#98 >= -1
 vincolo_timtjmxigem1#279:      - x9#8 + t#89 - t#99 >= -1
 vincolo_timtjmxigem1#280:      - x9#8 + t#89 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#281:      x9#8 - f#42 + f#43 + f#45 - f#46 - f#108  = 0
 __vincolo_timxile0#282:        - x10#9 + t#90 <= 0
 __vincolo_f0imnatile0#283:     - 20 t#90 + f#109 <= 0
 vincolo_timtjmxigem1#284:      - x10#9 + t#90 - t#91 >= -1
 vincolo_timtjmxigem1#285:      - x10#9 + t#90 - t#92 >= -1
 vincolo_timtjmxigem1#286:      - x10#9 + t#90 - t#93 >= -1
 vincolo_timtjmxigem1#287:      - x10#9 + t#90 - t#94 >= -1
 vincolo_timtjmxigem1#288:      - x10#9 + t#90 - t#95 >= -1
 vincolo_timtjmxigem1#289:      - x10#9 + t#90 - t#96 >= -1
 vincolo_timtjmxigem1#290:      - x10#9 + t#90 - t#97 >= -1
 vincolo_timtjmxigem1#291:      - x10#9 + t#90 - t#98 >= -1
 vincolo_timtjmxigem1#292:      - x10#9 + t#90 - t#99 >= -1
 vincolo_timtjmxigem1#293:      - x10#9 + t#90 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#294:      x10#9 - f#45 + f#46 + f#48 - f#49 - f#109  = 0
 __vincolo_timxile0#295:        - x11#10 + t#91 <= 0
 __vincolo_f0imnatile0#296:     - 20 t#91 + f#110 <= 0
 vincolo_timtjmxigem1#297:      - x11#10 + t#91 - t#92 >= -1
 vincolo_timtjmxigem1#298:      - x11#10 + t#91 - t#93 >= -1
 vincolo_timtjmxigem1#299:      - x11#10 + t#91 - t#94 >= -1
 vincolo_timtjmxigem1#300:      - x11#10 + t#91 - t#95 >= -1
 vincolo_timtjmxigem1#301:      - x11#10 + t#91 - t#96 >= -1
 vincolo_timtjmxigem1#302:      - x11#10 + t#91 - t#97 >= -1
 vincolo_timtjmxigem1#303:      - x11#10 + t#91 - t#98 >= -1
 vincolo_timtjmxigem1#304:      - x11#10 + t#91 - t#99 >= -1
 vincolo_timtjmxigem1#305:      - x11#10 + t#91 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#306:      x11#10 - f#48 + f#49 + f#51 - f#52 - f#110  = 0
 __vincolo_timxile0#307:        - x12#11 + t#92 <= 0
 __vincolo_f0imnatile0#308:     - 20 t#92 + f#111 <= 0
 vincolo_timtjmxigem1#309:      - x12#11 + t#92 - t#93 >= -1
 vincolo_timtjmxigem1#310:      - x12#11 + t#92 - t#94 >= -1
 vincolo_timtjmxigem1#311:      - x12#11 + t#92 - t#95 >= -1
 vincolo_timtjmxigem1#312:      - x12#11 + t#92 - t#96 >= -1
 vincolo_timtjmxigem1#313:      - x12#11 + t#92 - t#97 >= -1
 vincolo_timtjmxigem1#314:      - x12#11 + t#92 - t#98 >= -1
 vincolo_timtjmxigem1#315:      - x12#11 + t#92 - t#99 >= -1
 vincolo_timtjmxigem1#316:      - x12#11 + t#92 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#317:      x12#11 - f#51 + f#52 + f#54 - f#55 - f#111  = 0
 __vincolo_timxile0#318:        - x13#12 + t#93 <= 0
 __vincolo_f0imnatile0#319:     - 20 t#93 + f#112 <= 0
 vincolo_timtjmxigem1#320:      - x13#12 + t#93 - t#94 >= -1
 vincolo_timtjmxigem1#321:      - x13#12 + t#93 - t#95 >= -1
 vincolo_timtjmxigem1#322:      - x13#12 + t#93 - t#96 >= -1
 vincolo_timtjmxigem1#323:      - x13#12 + t#93 - t#97 >= -1
 vincolo_timtjmxigem1#324:      - x13#12 + t#93 - t#98 >= -1
 vincolo_timtjmxigem1#325:      - x13#12 + t#93 - t#99 >= -1
 vincolo_timtjmxigem1#326:      - x13#12 + t#93 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#327:      x13#12 - f#54 + f#55 + f#57 - f#58 - f#112  = 0
 __vincolo_timxile0#328:        - x14#13 + t#94 <= 0
 __vincolo_f0imnatile0#329:     - 20 t#94 + f#113 <= 0
 vincolo_timtjmxigem1#330:      - x14#13 + t#94 - t#95 >= -1
 vincolo_timtjmxigem1#331:      - x14#13 + t#94 - t#96 >= -1
 vincolo_timtjmxigem1#332:      - x14#13 + t#94 - t#97 >= -1
 vincolo_timtjmxigem1#333:      - x14#13 + t#94 - t#98 >= -1
 vincolo_timtjmxigem1#334:      - x14#13 + t#94 - t#99 >= -1
 vincolo_timtjmxigem1#335:      - x14#13 + t#94 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#336:      x14#13 - f#57 + f#58 + f#60 - f#61 - f#113  = 0
 __vincolo_timxile0#337:        - x15#14 + t#95 <= 0
 __vincolo_f0imnatile0#338:     - 20 t#95 + f#114 <= 0
 vincolo_timtjmxigem1#339:      - x15#14 + t#95 - t#96 >= -1
 vincolo_timtjmxigem1#340:      - x15#14 + t#95 - t#97 >= -1
 vincolo_timtjmxigem1#341:      - x15#14 + t#95 - t#98 >= -1
 vincolo_timtjmxigem1#342:      - x15#14 + t#95 - t#99 >= -1
 vincolo_timtjmxigem1#343:      - x15#14 + t#95 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#344:      x15#14 - f#60 + f#61 + f#63 - f#64 - f#114  = 0
 __vincolo_timxile0#345:        - x16#15 + t#96 <= 0
 __vincolo_f0imnatile0#346:     - 20 t#96 + f#115 <= 0
 vincolo_timtjmxigem1#347:      - x16#15 + t#96 - t#97 >= -1
 vincolo_timtjmxigem1#348:      - x16#15 + t#96 - t#98 >= -1
 vincolo_timtjmxigem1#349:      - x16#15 + t#96 - t#99 >= -1
 vincolo_timtjmxigem1#350:      - x16#15 + t#96 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#351:      x16#15 - f#63 + f#64 + f#66 - f#67 - f#115  = 0
 __vincolo_timxile0#352:        - x17#16 + t#97 <= 0
 __vincolo_f0imnatile0#353:     - 20 t#97 + f#116 <= 0
 vincolo_timtjmxigem1#354:      - x17#16 + t#97 - t#98 >= -1
 vincolo_timtjmxigem1#355:      - x17#16 + t#97 - t#99 >= -1
 vincolo_timtjmxigem1#356:      - x17#16 + t#97 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#357:      x17#16 - f#66 + f#67 + f#69 - f#70 - f#116  = 0
 __vincolo_timxile0#358:        - x18#17 + t#98 <= 0
 __vincolo_f0imnatile0#359:     - 20 t#98 + f#117 <= 0
 vincolo_timtjmxigem1#360:      - x18#17 + t#98 - t#99 >= -1
 vincolo_timtjmxigem1#361:      - x18#17 + t#98 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#362:      x18#17 - f#69 + f#70 + f#72 - f#73 - f#78
                                + f#79 - f#117  = 0
 __vincolo_timxile0#363:        - x19#18 + t#99 <= 0
 __vincolo_f0imnatile0#364:     - 20 t#99 + f#118 <= 0
 vincolo_timtjmxigem1#365:      - x19#18 + t#99 - t#100 >= -1
 sum_Fijm_sum_Fjiemxi#366:      x19#18 - f#72 + f#73 + f#75 - f#76 - f#118  = 0
 __vincolo_timxile0#367:        - x20#19 + t#100 <= 0
 __vincolo_f0imnatile0#368:     - 20 t#100 + f#119 <= 0
 sum_Fijm_sum_Fjiemxi#369:      x20#19 - f#75 + f#76 + f#78 - f#79 - f#119  = 0
 vincolo_sommatoria_tie1#370:   t#80 + t#82 + t#83 + t#84 + t#85 + t#86 + t#87
                                + t#88 + t#89 + t#90 + t#91 + t#92 + t#93
                                + t#94 + t#95 + t#96 + t#97 + t#98 + t#99
                                + t#100  = 1
 sommatoria_foim_somm_xie0#371: - x1#0 - x2#1 - x3#2 - x4#3 - x5#4 - x6#5
                                - x7#6 - x8#7 - x9#8 - x10#9 - x11#10 - x12#11
                                - x13#12 - x14#13 - x15#14 - x16#15 - x17#16
                                - x18#17 - x19#18 - x20#19 + f#81 + f#101
                                + f#102 + f#103 + f#104 + f#105 + f#106 + f#107
                                + f#108 + f#109 + f#110 + f#111 + f#112 + f#113
                                + f#114 + f#115 + f#116 + f#117 + f#118 + f#119
                                 = 0
Bounds
 0 <= x1#0 <= 1
 0 <= x2#1 <= 1
 0 <= x3#2 <= 1
 0 <= x4#3 <= 1
 0 <= x5#4 <= 1
 0 <= x6#5 <= 1
 0 <= x7#6 <= 1
 0 <= x8#7 <= 1
 0 <= x9#8 <= 1
 0 <= x10#9 <= 1
 0 <= x11#10 <= 1
 0 <= x12#11 <= 1
 0 <= x13#12 <= 1
 0 <= x14#13 <= 1
 0 <= x15#14 <= 1
 0 <= x16#15 <= 1
 0 <= x17#16 <= 1
 0 <= x18#17 <= 1
 0 <= x19#18 <= 1
 0 <= x20#19 <= 1
 0 <= y#20 <= 1
 0 <= y#23 <= 1
 0 <= y#26 <= 1
 0 <= y#29 <= 1
 0 <= y#32 <= 1
 0 <= y#35 <= 1
 0 <= y#38 <= 1
 0 <= y#41 <= 1
 0 <= y#44 <= 1
 0 <= y#47 <= 1
 0 <= y#50 <= 1
 0 <= y#53 <= 1
 0 <= y#56 <= 1
 0 <= y#59 <= 1
 0 <= y#62 <= 1
 0 <= y#65 <= 1
 0 <= y#68 <= 1
 0 <= y#71 <= 1
 0 <= y#74 <= 1
 0 <= y#77 <= 1
 0 <= t#80 <= 1
 0 <= t#82 <= 1
 0 <= t#83 <= 1
 0 <= t#84 <= 1
 0 <= t#85 <= 1
 0 <= t#86 <= 1
 0 <= t#87 <= 1
 0 <= t#88 <= 1
 0 <= t#89 <= 1
 0 <= t#90 <= 1
 0 <= t#91 <= 1
 0 <= t#92 <= 1
 0 <= t#93 <= 1
 0 <= t#94 <= 1
 0 <= t#95 <= 1
 0 <= t#96 <= 1
 0 <= t#97 <= 1
 0 <= t#98 <= 1
 0 <= t#99 <= 1
 0 <= t#100 <= 1
Binaries
 x1#0  x2#1  x3#2  x4#3  x5#4  x6#5  x7#6  x8#7  x9#8  x10#9  x11#10  x12#11 
 x13#12  x14#13  x15#14  x16#15  x17#16  x18#17  x19#18  x20#19  y#20  y#23 
 y#26  y#29  y#32  y#35  y#38  y#41  y#44  y#47  y#50  y#53  y#56  y#59  y#62 
 y#65  y#68  y#71  y#74  y#77  t#80  t#82  t#83  t#84  t#85  t#86  t#87  t#88 
 t#89  t#90  t#91  t#92  t#93  t#94  t#95  t#96  t#97  t#98  t#99  t#100 
End
