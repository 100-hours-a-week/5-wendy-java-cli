package wendy.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RecommendUtils {
    public static HorrorDetails recommendHorror(Scanner scan, String searchRegion, List<HorrorDetails> horrorThemes) {
        List<HorrorDetails> recommendedThemes = new ArrayList<>();
        System.out.print("-> 공포 ( 1.스릴러(약공포) 2.공포 3.상관없음 ) : ");
        int wantHorror = Integer.parseInt(scan.next());
        if (wantHorror == 3) {
            wantHorror = (int) (Math.random() * 2) + 1;
        }
        switch (wantHorror) {
            case 1:
                System.out.println();
                System.out.println("******스릴러 테마******");
                for (HorrorDetails thrill : horrorThemes) {
                    if (thrill.getGenre().equals("스릴러") && thrill.getRegion().equals(searchRegion)) {
//                        System.out.println(thrill.getStorename() + "의 " + thrill.getThemename());
                        recommendedThemes.add(thrill);
                    }
                }
                break;
            case 2:
                System.out.println();
                System.out.println("******공포 테마******");
                for (HorrorDetails horror : horrorThemes) {
                    if (horror.getGenre().equals("공포") && horror.getRegion().equals(searchRegion)) {
//                        System.out.println(horror.getStorename() + "의 " + horror.getThemename());
                        recommendedThemes.add(horror);
                    }
                }
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return null;
        }
        if (!recommendedThemes.isEmpty()) {
            Random random = new Random();
            return recommendedThemes.get(random.nextInt(recommendedThemes.size()));
        } else {
            System.out.println("추천할 매장이 아직 없습니다.");
            return null;
        }
    }


    public static SubjectiveDetails recommendNonHorror(Scanner scan, String name, String searchRegion, List<SubjectiveDetails> themes) {
        String searchTheme ="";
        int searchLevel;
        System.out.print("-> 공포 제외 ( 1.동화 2.코믹 3.판타지 4.어드벤처 5.감성 6.상관없음 ) : ");
        int wantNotHorror = Integer.parseInt(scan.next());
        if (wantNotHorror == 6) {
            wantNotHorror = (int) (Math.random() * 5) + 1;
        }
        switch (wantNotHorror) {
            case 1:
                searchTheme = "동화";
                break;
            case 2:
                searchTheme = "코믹";
                break;
            case 3:
                searchTheme = "판타지";
                break;
            case 4:
                searchTheme = "어드벤처";
                break;
            case 5:
                searchTheme = "감성";
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return null;
        }
        System.out.print(name + "님 테마를 플레이할 인원을 알려주세요 : ");
        int wantPersonnel = Integer.parseInt(scan.next());
        if (wantPersonnel == 1) {
            System.out.println("혼방 추천 불가,,");
            return null;
        }
        System.out.print("방탈출 경험 횟수를 입력해주세요(경험 없으면 0) : ");
        int playCount = Integer.parseInt(scan.next());
        if (playCount <= 50) {
            searchLevel = 2;
        } else if (playCount > 50 && playCount <= 150) {
            searchLevel = 3;
        } else {
            searchLevel = 4;
        }
        List<SubjectiveDetails> recommendedThemes = new ArrayList<>();
        System.out.println();
        System.out.println("***************추천 테마***************");
        for (SubjectiveDetails theme : themes) {
            if (theme.getGenre().equals(searchTheme) && theme.getRegion().equals(searchRegion) && theme.getPlayMember() == wantPersonnel && searchLevel <= theme.getSubjectiveDifficulty() && theme.getSubjectiveDifficulty() <= searchLevel + 1) {
//                System.out.println(theme.getStorename() + "의 " + theme.getThemename());
                recommendedThemes.add(theme);
            }
        }
        if (!recommendedThemes.isEmpty()) {
            Random random = new Random();
            return recommendedThemes.get(random.nextInt(recommendedThemes.size()));
        } else {
            System.out.println("추천할 테마가 없습니다.");
            return null;
        }
    }

}
