//import java.io.IOException;
//import java.util.*;
//
//public class Solution {
//    static int psum = 0;
//    static int psum_11 = 0;
//    static int dsum = 0;
//    static ArrayList<Integer> p;
//    static ArrayList<Integer> d;
//    static int d2;
//
//    public static void main(String[] args) throws IOException {
////        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer str = new StringTokenizer(bfr.readLine());
//
//        int[] cards = {1, 4, 10, 6, 9, 1, 8, 13};
//        solution(cards);
//    }
//
//
//
//    public static int solution(int[] cards) {
//        ArrayList<Integer> cardar = new ArrayList<>();
//         p =new ArrayList<>();
//         d = new ArrayList<>();
//        for(int i=0; i<cards.length; i++) {
//            cardar.add(cards[i]);
//        }
//
//        int result = 0;
//        while(true) {
//            if (!getTwo(cardar))
//                break;
//            else {
//                System.out.println(psum+" "+dsum);
//                if (psum == 21) {
//                    boolean flag = true;
//                    while (dsum < 17) {
//                        flag = getDealer(cardar, 17);
//                        if (!flag) break;
//                    }
//                    if (flag) {
//                        if (dsum != 21)
//                            result += 3;
//                    }
//                } else if (psum < 21) {
//                    if (d2 == 1 || d2 >= 7) {
//                        boolean pflag = true;
//                        while (psum < 17) {
//                            pflag = getPlayer(cardar, 17);
//                            if (!pflag) break;
//                        }
//                        if (psum > 21) {
//                            result -= 2;
//                            pflag = false;
//                        }
//                        boolean dflag = true;
//                        while (pflag && dsum < 17) {
//                            dflag = getDealer(cardar, 17);
//                            if (!dflag) break;
//                        }
//                        if (dsum > 21) {
//                            if (psum == 21) {
//                                result += 3;
//                            } else
//                                result += 2;
//                            dflag = false;
//                        }
//                        if (pflag && dflag) {
//                            if (psum > dsum) {
//                                if (psum == 21) {
//                                    result += 3;
//                                } else
//                                    result += 2;
//                            } else {
//                                result -= 2;
//                            }
//                        }
//                    } else if (d2 == 4 || d2 == 5 | d2 == 6) {
//                        boolean dflag = true;
//                        while (dsum < 17) {
//                            dflag = getDealer(cardar, 17);
//                            if (!dflag) break;
//                        }
//                        if (dsum > 21) {
//                            if (psum == 21) {
//                                result += 3;
//                            } else
//                                result += 2;
//                            dflag = false;
//                        }
//                        if (dflag) {
//                            if (psum > dsum) {
//                                if (psum == 21) {
//                                    result += 3;
//                                } else
//                                    result += 2;
//                            } else {
//                                result -= 2;
//                            }
//                        }
//                    } else if (d2 == 3 || d2 == 2) {
//                        boolean pflag = true;
//                        while (psum < 12) {
//                            pflag = getPlayer(cardar, 12);
//                            if (!pflag) break;
//                        }
//                        if (psum > 21) {
//                            result -= 2;
//                            pflag = false;
//                        }
//                        boolean dflag = true;
//                        while (pflag && dsum < 17) {
//                            dflag = getDealer(cardar, 12);
//                            if (!dflag) break;
//                        }
//                        if (dsum > 21) {
//                            if (psum == 21) {
//                                result += 3;
//                            } else
//                                result += 2;
//                            dflag = false;
//                        }
//                        if (pflag && dflag) {
//                            if (psum > dsum) {
//                                if (psum == 21) {
//                                    result += 3;
//                                } else
//                                    result += 2;
//                            } else {
//                                result -= 2;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(result);
//        return result;
//    }
//
//    static boolean getTwo(ArrayList<Integer> cardar) {
//        if(cardar.size()<4) {
//            return false;
//        }
//        else {
//            p.add(cardar.get(0));
//            getPlayer(cardar, 21);
//            d.add(cardar.get(0));
//            getDealer(cardar, 21);
//            p.add(cardar.get(0));
//            getPlayer(cardar, 21);
//            d.add(cardar.get(0));
//            d2 = cardar.get(0);
//            getDealer(cardar, 21);
//            return true;
//        }
//    }
//
//    static boolean getPlayer(ArrayList<Integer> cardar, int target) {
//        if(cardar.isEmpty()) {
//            return false;
//        }
//        else {
//            if(p.get(0)==1) {
//                if(11 + p.get(1)==21)
//                    psum = 21;
//                return true;
//            }
//            else if(p.get(1)==1) {
//            int getcard = cardar.get(0);
//            if(getcard>10) getcard = 10;
//            if(getcard==1) {
//                psum_11+=11;
//                if(psum+11==21 || psum+11>=target || psum_11==21 || psum_11>=target) {
//                    psum+=11;
//                    cardar.remove(0);
//                    return true;
//                }
//                else if(psum+1 == 21|| psum+1>=target) {
//                    psum+=1;
//                    cardar.remove(0);
//                    return true;
//                }
//            }
//            if(psum+getcard>21 || psum+getcard<target) {
//                psum+=getcard;
//                cardar.remove(0);
//                return true;
//            }
//            else {
//                psum+=getcard;
//                cardar.remove(0);
//                return true;
//            }
//        }
//    }
//    static boolean getDealer(ArrayList<Integer> cardar, int target) {
//        if(cardar.isEmpty()) {
//            return false;
//        }
//
//        else {
//            int getcard = cardar.get(0);
//            if(getcard>10) getcard = 10;
//            if(getcard==1) {
//                if(dsum+11==21 || dsum+11>=target) {
//                    dsum+=11;
//                    cardar.remove(0);
//                    return true;
//                }
//                else if(dsum+1 == 21|| dsum+1>=target) {
//                    dsum+=1;
//                    cardar.remove(0);
//                    return true;
//                }
//            }
//            if(dsum+getcard>21 || dsum+getcard<target) {
//                dsum+=getcard;
//                cardar.remove(0);
//                return true;
//            }
//            else {
//                dsum+=getcard;
//                cardar.remove(0);
//                return true;
//            }
//        }
//    }
//
//}
