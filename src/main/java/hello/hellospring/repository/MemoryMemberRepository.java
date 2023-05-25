package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

private static Map<Long, Member> store = new HashMap<>();
private static long sequence = 0L; //시퀀스 생성

    @Override
    public Member sava(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null값을 optional로
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
        .filter(Member-> Member.getName().equals(name))
        .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
