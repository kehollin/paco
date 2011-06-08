/*
* Copyright 2011 Google Inc. All Rights Reserved.
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance  with the License.  
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g 2010-10-13 17:58:12

package com.google.android.apps.paco.questioncondparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QuestionConditionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LT", "INTEGER", "GT", "EQ", "NE", "OR", "AND", "QUESTION_NAME", "COMMENT", "WS", "ESC_SEQ", "STRING", "CHAR", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC"
    };
    public static final int UNICODE_ESC=18;
    public static final int WS=13;
    public static final int CHAR=16;
    public static final int EQ=7;
    public static final int STRING=15;
    public static final int LT=4;
    public static final int GT=6;
    public static final int NE=8;
    public static final int COMMENT=12;
    public static final int ESC_SEQ=14;
    public static final int OR=9;
    public static final int QUESTION_NAME=11;
    public static final int INTEGER=5;
    public static final int AND=10;
    public static final int EOF=-1;
    public static final int HEX_DIGIT=17;
    public static final int OCTAL_ESC=19;

    // delegates
    // delegators


        public QuestionConditionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QuestionConditionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return QuestionConditionParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g"; }


       Environment environment;
       public QuestionConditionParser(TokenStream input, Environment environment) {
           this(input);
           this.environment = environment;
       }



    // $ANTLR start "comparison"
    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:17:1: comparison returns [boolean value] : ( question_part LT i= INTEGER | question_part GT i= INTEGER | question_part EQ i= INTEGER | question_part NE i= INTEGER );
    public final boolean comparison() throws RecognitionException {
        boolean value = false;

        Token i=null;
        QuestionConditionParser.question_part_return question_part1 = null;

        QuestionConditionParser.question_part_return question_part2 = null;

        QuestionConditionParser.question_part_return question_part3 = null;

        QuestionConditionParser.question_part_return question_part4 = null;


        try {
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:18:4: ( question_part LT i= INTEGER | question_part GT i= INTEGER | question_part EQ i= INTEGER | question_part NE i= INTEGER )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==QUESTION_NAME) ) {
                switch ( input.LA(2) ) {
                case LT:
                    {
                    alt1=1;
                    }
                    break;
                case NE:
                    {
                    alt1=4;
                    }
                    break;
                case EQ:
                    {
                    alt1=3;
                    }
                    break;
                case GT:
                    {
                    alt1=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:18:6: question_part LT i= INTEGER
                    {
                    pushFollow(FOLLOW_question_part_in_comparison37);
                    question_part1=question_part();

                    state._fsp--;

                    match(input,LT,FOLLOW_LT_in_comparison39); 
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_comparison43); 
                     value = environment.getValue((question_part1!=null?input.toString(question_part1.start,question_part1.stop):null)) != null && environment.getValue((question_part1!=null?input.toString(question_part1.start,question_part1.stop):null)) < Integer.parseInt((i!=null?i.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:19:6: question_part GT i= INTEGER
                    {
                    pushFollow(FOLLOW_question_part_in_comparison52);
                    question_part2=question_part();

                    state._fsp--;

                    match(input,GT,FOLLOW_GT_in_comparison54); 
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_comparison58); 
                     value = environment.getValue((question_part2!=null?input.toString(question_part2.start,question_part2.stop):null)) != null && environment.getValue((question_part2!=null?input.toString(question_part2.start,question_part2.stop):null)) > Integer.parseInt((i!=null?i.getText():null)); 

                    }
                    break;
                case 3 :
                    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:20:6: question_part EQ i= INTEGER
                    {
                    pushFollow(FOLLOW_question_part_in_comparison67);
                    question_part3=question_part();

                    state._fsp--;

                    match(input,EQ,FOLLOW_EQ_in_comparison69); 
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_comparison73); 
                     value = environment.getValue((question_part3!=null?input.toString(question_part3.start,question_part3.stop):null)) != null && environment.getValue((question_part3!=null?input.toString(question_part3.start,question_part3.stop):null)) == Integer.parseInt((i!=null?i.getText():null)); 

                    }
                    break;
                case 4 :
                    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:21:6: question_part NE i= INTEGER
                    {
                    pushFollow(FOLLOW_question_part_in_comparison82);
                    question_part4=question_part();

                    state._fsp--;

                    match(input,NE,FOLLOW_NE_in_comparison84); 
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_comparison88); 
                     value = environment.getValue((question_part4!=null?input.toString(question_part4.start,question_part4.stop):null)) != null && environment.getValue((question_part4!=null?input.toString(question_part4.start,question_part4.stop):null)) != Integer.parseInt((i!=null?i.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "comparison"


    // $ANTLR start "expression"
    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:24:1: expression returns [boolean value] : c= comparison ( OR c1= comparison | AND c1= comparison )* ;
    public final boolean expression() throws RecognitionException {
        boolean value = false;

        boolean c = false;

        boolean c1 = false;


        try {
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:25:4: (c= comparison ( OR c1= comparison | AND c1= comparison )* )
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:25:8: c= comparison ( OR c1= comparison | AND c1= comparison )*
            {
            pushFollow(FOLLOW_comparison_in_expression113);
            c=comparison();

            state._fsp--;

            value = c;
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:26:4: ( OR c1= comparison | AND c1= comparison )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==OR) ) {
                    alt2=1;
                }
                else if ( (LA2_0==AND) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:26:6: OR c1= comparison
            	    {
            	    match(input,OR,FOLLOW_OR_in_expression122); 
            	    pushFollow(FOLLOW_comparison_in_expression126);
            	    c1=comparison();

            	    state._fsp--;

            	    value = value || c1; 

            	    }
            	    break;
            	case 2 :
            	    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:27:6: AND c1= comparison
            	    {
            	    match(input,AND,FOLLOW_AND_in_expression135); 
            	    pushFollow(FOLLOW_comparison_in_expression139);
            	    c1=comparison();

            	    state._fsp--;

            	    value = value && c1; 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expression"

    public static class question_part_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "question_part"
    // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:31:1: question_part : QUESTION_NAME ;
    public final QuestionConditionParser.question_part_return question_part() throws RecognitionException {
        QuestionConditionParser.question_part_return retval = new QuestionConditionParser.question_part_return();
        retval.start = input.LT(1);

        Token QUESTION_NAME5=null;

        try {
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:32:1: ( QUESTION_NAME )
            // /Users/bobevans/Documents/projects/pacoandroid2/android2_workspace/Paco/src/com/google/sampling/experiential/questioncondparser/QuestionCondition.g:32:2: QUESTION_NAME
            {
            QUESTION_NAME5=(Token)match(input,QUESTION_NAME,FOLLOW_QUESTION_NAME_in_question_part158); 
             if (!environment.exists((QUESTION_NAME5!=null?QUESTION_NAME5.getText():null))) {
                   throw new IllegalArgumentException("unknown reference: " + (QUESTION_NAME5!=null?QUESTION_NAME5.getText():null));
               }
               if (!environment.correctType((QUESTION_NAME5!=null?QUESTION_NAME5.getText():null))) {
                 throw new IllegalArgumentException("Does not have an integer response type: " + (QUESTION_NAME5!=null?QUESTION_NAME5.getText():null));
               }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "question_part"

    // Delegated rules


 

    public static final BitSet FOLLOW_question_part_in_comparison37 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LT_in_comparison39 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INTEGER_in_comparison43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_part_in_comparison52 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_GT_in_comparison54 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INTEGER_in_comparison58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_part_in_comparison67 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EQ_in_comparison69 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INTEGER_in_comparison73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_part_in_comparison82 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NE_in_comparison84 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INTEGER_in_comparison88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_expression113 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_OR_in_expression122 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_comparison_in_expression126 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_AND_in_expression135 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_comparison_in_expression139 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_QUESTION_NAME_in_question_part158 = new BitSet(new long[]{0x0000000000000002L});

}