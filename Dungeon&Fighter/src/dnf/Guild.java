package dnf;

import java.util.ArrayList;

public class Guild {
private final int partySize = 4;
public ArrayList<Player> guildMember = new ArrayList<>();
public Unit[] partyList;
//����� ���
//���� �߰�
// ���� ����
// ��Ƽ�� ��ü
//����
private void setGuild() {
	for(int i = 0 ; i<UnitManager.player_list.size();i++) {
		Player player = UnitManager.player_list.get(i);
		guildMember.add(player);
	}
}


}
