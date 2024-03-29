package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제를 해결하기 위해 ConcurrentHashMap울 사용한다.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
