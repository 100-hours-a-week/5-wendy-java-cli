package wendy.program;

import java.util.*;

public class EscapeRoomRecommend {
    int REGION_RANDOM = 4;
    int GENRE_RANDOM = 3;
    int BY_REGION = 1;
    int PERSONALIZED = 2;

    public void process(){
        EscapeRoomData escapeRoomData = getEscapeRoomData();
        Scanner scan = new Scanner(System.in);

        String name = inputName(scan);
        printInfo(name);
        int recommendType = inputRecommendType(scan);
        if (recommendType==BY_REGION) {
            recommendByRegion(scan, name, escapeRoomData.stores());
        } else if (recommendType==PERSONALIZED) {
            personalizedRecommendation(scan, name, escapeRoomData.horrorThemes(), escapeRoomData.themes());
        }else{
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
    }


    private String inputName(Scanner scan) {
        System.out.println("안녕하세요 방탈출 추천 프로그램입니다.");
        System.out.print("이름을 먼저 입력해주세요 : ");
        String name = scan.next();
        return name;
    }

    private void printInfo(String name) {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println(name + "님 이제부터 답변은 숫자만 입력해주세요");
        System.out.println("-----------------------------");
        System.out.println();
    }

    private int inputRecommendType(Scanner scan) {
        System.out.println("원하시는 추천을 선택해주세요");
        System.out.print("1. 지역별 매장 추천 2. 개인 맞춤형 추천 -> ");
        int wanttype = getValidatedInput(scan, 1, 2);
        System.out.println();
        return wanttype;
    }

    private void recommendByRegion(Scanner scan, String name, List<EscapeRoomStore> stores) {
        System.out.println("---------<지역별 매장 추천>---------");
        System.out.print(name + "님 추천받고 싶은 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.랜덤) : ");
        int wantRegion = getValidatedInput(scan, 1, 4);
        if (wantRegion == REGION_RANDOM) {
            wantRegion = (int) (Math.random() * 3) + 1;
        }
        System.out.println();
        List<EscapeRoomStore> filteredStores = new ArrayList<>();
        switch (wantRegion) {
            case 1:
                System.out.println("**강남의 방탈출 매장 랜덤 추천**");
                for (EscapeRoomStore store : stores) {
                    if (store.getRegion().equals("강남")) {
                        filteredStores.add(store);
                    }
                }
                break;
            case 2:
                System.out.println("**건대의 방탈출 매장 랜덤 추천**");
                for (EscapeRoomStore store : stores) {
                    if (store.getRegion().equals("건대")) {
                        filteredStores.add(store);
                    }
                }
                break;
            case 3:
                System.out.println("**홍대의 방탈출 매장 랜덤 추천**");
                for (EscapeRoomStore store : stores) {
                    if (store.getRegion().equals("홍대")) {
                        filteredStores.add(store);
                    }
                }
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        }
        if (!filteredStores.isEmpty()) {
            Random random = new Random();
            EscapeRoomStore randomStore = filteredStores.get(random.nextInt(filteredStores.size()));
            System.out.println("추천 매장: " + randomStore.getStorename());
        } else {
            System.out.println("해당 지역에 추천할 매장이 없습니다.");
        }
    }

    private void personalizedRecommendation(Scanner scan, String name, List<HorrorDetails> horrorThemes, List<SubjectiveDetails> themes) {
        String searchRegion = "";
        String searchTheme = "";
        int searchLevel;

        System.out.println("---------<본인 맞춤형 추천>---------");
        System.out.print("원하는 플레이 지역을 선택해주세요. (1.강남 2.건대 3.홍대 4.랜덤) : ");
        int wantRegion = getValidatedInput(scan, 1, 4);
        if (wantRegion == REGION_RANDOM) {
            wantRegion = (int) (Math.random() * 3) + 1;
        }
        switch (wantRegion) {
            case 1:
                searchRegion = "강남";
                break;
            case 2:
                searchRegion = "건대";
                break;
            case 3:
                searchRegion = "홍대";
                break;
            default:
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return;
        }
        System.out.print(name + "님 원하는 테마 장르가 있으신가요? (1.공포 2.공포 제외 3.상관없음) : ");
        int wantGenre = getValidatedInput(scan, 1, 3);
        if (wantGenre == GENRE_RANDOM) {
            wantGenre = (int) (Math.random() * 2) + 1;
        }
        RecommendationUtils recommendationUtils = new RecommendationUtils();
        if (wantGenre == 1) {
            recommendationUtils.recommendHorror(scan, searchRegion, horrorThemes);
        } else if (wantGenre==2){
            recommendationUtils.recommendNonHorror(scan, name, searchRegion, themes);
        }
    }

    private int getValidatedInput(Scanner scan, int min, int max) {
        while (true) {
            try {
                int input = scan.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("잘못된 입력입니다. 보기에 있는 숫자를 입력해주세요. ");
                }
            } catch (InputMismatchException e) {
                System.out.print("잘못된 입력입니다. 숫자를 입력해주세요. ");
                scan.next();
            }
        }
    }

    public EscapeRoomData getEscapeRoomData() {
        List<EscapeRoomStore> stores = new ArrayList<>();
        stores.add(new EscapeRoomStore("강남", "키이스케이프 강남점"));
        stores.add(new EscapeRoomStore("강남", "제로월드"));
        stores.add(new EscapeRoomStore("강남", "우주라이크"));
        stores.add(new EscapeRoomStore("강남", "포인트나인"));
        stores.add(new EscapeRoomStore("강남", "키이스케이프 메모리컴퍼니"));
        stores.add(new EscapeRoomStore("강남", "황금열쇠 강남점(타임스퀘어)"));
        stores.add(new EscapeRoomStore("홍대", "비트포비아 홍대던전3"));
        stores.add(new EscapeRoomStore("홍대", "룸엘이스케이프 홍대점"));
        stores.add(new EscapeRoomStore("홍대", "퀘스천마크 홍대점"));
        stores.add(new EscapeRoomStore("홍대", "포인트나인 홍대점"));
        stores.add(new EscapeRoomStore("홍대", "디코더"));
        stores.add(new EscapeRoomStore("홍대", "키이스케이프 홍대점"));
        stores.add(new EscapeRoomStore("건대", "비밀의 화원 포레스트"));
        stores.add(new EscapeRoomStore("건대", "넥스트에디션 건대1호점"));
        stores.add(new EscapeRoomStore("건대", "넥스트에디션 건대2호점"));
        stores.add(new EscapeRoomStore("건대", "드림이스케이프"));
        stores.add(new EscapeRoomStore("건대", "황금열쇠 건대유토피아호점"));
        stores.add(new EscapeRoomStore("건대", "엑스케이프"));

        List<HorrorDetails> horrorThemes = new ArrayList<>();
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "포레스트", "공포", 27000, 4, 4.5));
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "아이엠", "스릴러", 27000, 4, 1));
        horrorThemes.add(new HorrorDetails("강남", "제로월드", "콜러", "공포", 27000, 5, 5));
        horrorThemes.add(new HorrorDetails("강남", "마스터키", "도시괴담1", "공포", 22000, 4, 4));
        horrorThemes.add(new HorrorDetails("건대", "황금열쇠 건대유토피아호점", "fl[ae]sh", "공포", 25000, 3, 4));
        horrorThemes.add(new HorrorDetails("홍대", "룸엘이스케이프", "퇴근길", "스릴러", 28000, 3, 4));

        List<SubjectiveDetails> themes = new ArrayList<>();
        themes.add(new SubjectiveDetails("강남", "황금열쇠 강남점(타임스퀘어)", "NOMON : THE ORDEAL", "판타지", 27000, 3, 4, 4, 4));
        themes.add(new SubjectiveDetails("강남", "키이스케이프 강남점", "그카지말라캤자나ㅋ", "코믹", 25000, 4, 3, 3, 3));
        themes.add(new SubjectiveDetails("강남", "키이스케이프 강남점", "월야애담-영문병행표기", "동화", 24000, 4, 2, 3, 2));
        themes.add(new SubjectiveDetails("강남", "우주라이크", "US", "판타지", 28000, 3.5, 4, 5, 3));
        themes.add(new SubjectiveDetails("강남", "도어이스케이프 레드", "lucky", "코믹", 27000, 4, 4, 4, 4));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "시간이 멈춘 마을", "동화", 27000, 4, 4, 4.5, 3));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "시간이 멈춘 마을(2)", "동화", 27000, 4, 4, 4.5, 3));
        themes.add(new SubjectiveDetails("강남", "포인트나인", "열쇠공의 이중생활", "동화", 27000, 4, 4.5, 4, 3));
        themes.add(new SubjectiveDetails("홍대", "오아시스 뮤지엄", "미씽 삭스 미스터리", "어드벤처", 27000, 3, 3.5, 3.5, 4));
        themes.add(new SubjectiveDetails("홍대", "오아시스 뮤지엄", "업사이드 다운", "어드벤처", 28000, 3, 3, 3.5, 3));
        themes.add(new SubjectiveDetails("홍대", "키이스케이프 홍대점", "삐릿-뽀", "어드벤처", 27000, 4, 4, 3, 4));
        themes.add(new SubjectiveDetails("홍대", "디코더", "템포루바토", "동화", 28000, 3.5, 3.5, 5, 2));
        themes.add(new SubjectiveDetails("건대", "비밀의 화원 포레스트", "새벽 베이커리", "감성", 22000, 4, 3.5, 3.5, 4));
        themes.add(new SubjectiveDetails("건대", "비밀의 화원 포레스트", "미씽 스노우맨", "감성", 25000, 2, 3, 4, 3));
        themes.add(new SubjectiveDetails("건대", "넥스트에디션 건대2호점", "커튼콜", "판타지", 24000, 3, 3.5, 3.5, 3));
        themes.add(new SubjectiveDetails("건대", "넥스트에디션 건대2호점", "동화나라 수비대", "동화", 26000, 5, 4.5, 3.5, 4));
        themes.add(new SubjectiveDetails("건대", "넥스트에디션 건대2호점", "빛을 구해줘", "동화", 22000, 4, 3, 3, 3));
        EscapeRoomData result = new EscapeRoomData(stores, horrorThemes, themes);
        return result;
    }

    public record EscapeRoomData(List<EscapeRoomStore> stores, List<HorrorDetails> horrorThemes, List<SubjectiveDetails> themes) {
    }

}
