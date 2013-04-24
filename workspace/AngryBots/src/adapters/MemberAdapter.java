package adapters;

public class MemberAdapter {
	private static base.Member member = null;
	private MemberAdapter() {}
	
	public static base.Member getMember() {
		return MemberAdapter.member;
	}
	
	public static void setMember(base.Member member) {
		MemberAdapter.member = member;
	}
	
	public static void setPoints(long points) {
		if (MemberAdapter.member != null) {
			MemberAdapter.member.setPoints(points);
		}
	}

}
