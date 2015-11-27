package forest.rice.field.k.medalist2.entity;

import android.support.v7.util.SortedList;

public class MedalEntity {

    public String name;
    public String id;
    public String family;
    public String phase;
    public String yomi;
    public String product;
    public String frame;
    public String watch1;
    public String watch2;
    public String watch3;
    public String watch4;
    public String game1;
    public String game2;
    public String game3;
    public String sort_num;

    public static MedalEntity createMedalEntity(String input) {
        String[] splitValue = input.split("\t", -1);

        MedalEntity entity = new MedalEntity();

        try {
            entity.name = splitValue[0];
            entity.id = splitValue[1];
            entity.family = splitValue[2];
            entity.phase = splitValue[3];
            entity.yomi = splitValue[4];
            entity.product = splitValue[5];
            entity.frame = splitValue[6];
            entity.watch1 = splitValue[7];
            entity.watch2 = splitValue[8];
            entity.watch3 = splitValue[9];
            entity.watch4 = splitValue[10];
            entity.game1 = splitValue[11];
            entity.game2 = splitValue[12];
            entity.game3 = splitValue[13];
            entity.sort_num = splitValue[14];
        } catch (Exception e) {

        }

        return entity;
    }

    public static SortedList<MedalEntity> createMedalEntityList(String input) {
        String[] splitValue = input.split("\r\n", -1);

        SortedList<MedalEntity> sortedList = new SortedList<MedalEntity>(MedalEntity.class, new SortedListCallback());

        for (String value : splitValue) {
            MedalEntity entity = createMedalEntity(value);

            if (entity == null) {
                continue;
            }

            if (entity.phase == null || entity.phase.equals("")) {
                continue;
            }
            if (entity.name == null || entity.name.equals("name")) {
                continue;
            }

            sortedList.add(entity);
        }

        return sortedList;
    }

    public String getMedalImage() {
        return String.format("http://yw.b-boys.jp/member/images/items/list/medal/%s/img_medal%s.png", phase, id);
    }

    public String getCharactorImage() {
        return String.format("http://yw.b-boys.jp/member/images/items/detail/yokai/%s/pic%s.png", phase, id);
    }

}
