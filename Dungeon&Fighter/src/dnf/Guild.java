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
	guildMember.add(new PlayerStriker());
	guildMember.add(new PlayerNenMaster());
	guildMember.add(new PlayerSaint());
	guildMember.add(new PlayerWeaponMaster());

}
}
