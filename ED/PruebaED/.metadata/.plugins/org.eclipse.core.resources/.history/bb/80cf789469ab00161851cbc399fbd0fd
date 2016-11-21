package arbolesUO251017;

import static org.junit.Assert.*;

import org.junit.Test;

import evalNestor.EvalAVLTree;
import evalNestor.EvalBSTree;

public class TreesTestEjemplo {

	@Test
	public void testBSTree() {
		EvalBSTree<Integer> bE = new EvalBSTree<Integer>();
		
		for (int i=5;i>-5;i-=2) {
			assertTrue("add("+i+") ",bE.add(i));
			assertTrue("add("+(-(i-1))+") ",bE.add(-(i-1)));
		}

		assertEquals(
				"5\n"+
				"\t\t\t4\n"+
				"\t\t3\n"+
				"\t\t\t\t\t2\n"+
				"\t\t\t\t1\n"+
				"\t\t\t\t\t0\n"+
				"\t\t\t\t\t\t-1\n"+
				"\t\t\t-2\n"+
				"\t\t\t\t-3\n"+
				"\t-4\n"
				, bE.toString());
//		System.out.print(bE.inOrder());
		assertEquals("-4	-3	-2	-1	0	1	2	3	4	5	"
				, bE.inOrder());
//		System.out.print(bE.preOrder());
		assertEquals("5	-4	3	-2	-3	1	0	-1	2	4	"
				, bE.preOrder());
//		System.out.print(bE.postOrder());
		assertEquals("-3	-1	0	2	1	-2	4	3	-4	5	"
				, bE.postOrder());
	}

	
	@Test
	public void testAVLTree() {
		EvalAVLTree<Integer> bE = new EvalAVLTree<Integer>();
		
		for (int i=5;i>-5;i-=2) {
			assertTrue("add("+i+") ",bE.add(i));
			assertTrue("add("+(-(i-1))+") ",bE.add(-(i-1)));
		}
		System.out.println(bE.toString());
		assertEquals(
				"\t\t5:FB=-1\n"+
				"\t\t\t4:FB=0\n"+
				"\t3:FB=1\n"+
				"\t\t2:FB=0\n"+
				"1:FB=0\n"+
				"\t\t0:FB=-1\n"+
				"\t\t\t-1:FB=0\n"+
				"\t-2:FB=0\n"+
				"\t\t\t-3:FB=0\n"+
				"\t\t-4:FB=1\n"
				, bE.toString());
//		System.out.print(bE.inOrder());
		assertEquals("-4:FB=1	-3:FB=0	-2:FB=0	-1:FB=0	0:FB=-1	1:FB=0	2:FB=0	3:FB=1	4:FB=0	5:FB=-1	"
				, bE.inOrder());
//		System.out.print(bE.preOrder());
		assertEquals("1:FB=0	-2:FB=0	-4:FB=1	-3:FB=0	0:FB=-1	-1:FB=0	3:FB=1	2:FB=0	5:FB=-1	4:FB=0	"
				, bE.preOrder());
//		System.out.print(bE.postOrder());
		assertEquals("-3:FB=0	-4:FB=1	-1:FB=0	0:FB=-1	-2:FB=0	2:FB=0	4:FB=0	5:FB=-1	3:FB=1	1:FB=0	"
				, bE.postOrder());
	}
}
