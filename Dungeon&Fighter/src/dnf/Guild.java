package dnf;

import java.util.ArrayList;

public class Guild {
private final int partySize = 4;
public ArrayList<Player> guildMember = new ArrayList<>();
public Unit[] partyList;
//길드목록 출력
//길드원 추가
// 길드원 삭제
// 파티원 교체
//정렬
private void setGuild() {
	guildMember.add(new PlayerStriker());
	guildMember.add(new PlayerNenMaster());
	guildMember.add(new PlayerSaint());
	guildMember.add(new PlayerWeaponMaster());

}
}
