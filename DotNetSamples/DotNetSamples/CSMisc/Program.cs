﻿using System;
using System.Diagnostics;

namespace CSMisc
{
	class MainClass
	{
		public static void Main (string[] args)
		{

			var lazyTest = new LazyTest ();

			Console.WriteLine ("AddIfTrue is true x:4 y:5");
			Console.ReadLine ();
			var resultAddLazyTest = lazyTest.AddIfTrue (true, 4, 5);
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();

			Console.WriteLine ("AddIfTrue is false x:4 y:5");
			Console.ReadLine ();
			resultAddLazyTest = lazyTest.AddIfTrue (false, 4, 5);
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();

			Console.WriteLine ("AddIfTrue is true x:GetValueX() y:GetValueY()");
			Console.ReadLine ();
			resultAddLazyTest = lazyTest.AddIfTrue (true, lazyTest.GetValueX(), lazyTest.GetValueY());
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();

			Console.WriteLine ("AddIfTrue is false x:GetValueX() y:GetValueY()");
			Console.ReadLine ();
			resultAddLazyTest = lazyTest.AddIfTrue (false, lazyTest.GetValueX(), lazyTest.GetValueY());
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();

			Console.WriteLine ("AddIfTrueLazy is true x:GetValueX y:GetValueY");
			Console.ReadLine ();
			resultAddLazyTest = lazyTest.AddIfTrueLazy (true, lazyTest.GetValueX, lazyTest.GetValueY);
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();

			Console.WriteLine ("AddIfTrueLazy is false x:GetValueX y:GetValueY");
			Console.ReadLine ();
			resultAddLazyTest = lazyTest.AddIfTrueLazy (false, lazyTest.GetValueX, lazyTest.GetValueY);
			Console.WriteLine ("Result = {0}", resultAddLazyTest);
			Console.WriteLine ();
			Console.ReadLine ();


			var sw = Stopwatch.StartNew ();
			var resultFib = MemoizeTest.TestFib ();
			Console.WriteLine ("Test Fibonacci result {0},  time elapsed {1} msec",resultFib, sw.ElapsedMilliseconds.ToString ());

			sw = Stopwatch.StartNew ();
			resultFib = MemoizeTest.TestFibMem ();
			Console.WriteLine ("Test Fibonacci Memoize result {0},  time elapsed {1} msec",resultFib, sw.ElapsedMilliseconds.ToString ());

			Console.ReadLine ();



			//	var isAbundant = CSMisc.NumberClassifierFunctional.IsAbundant (6);
			//	Console.WriteLine (isAbundant);

			ImmutableTest immutableTest = new ImmutableTest ();
			immutableTest.Test ();

			immutableTest.RefactoredTest ();

			Console.ReadLine ();

			ImmutabilityClosure.LoopFunc ();

			// Statements don't return values, so you have to use temporary variables that are assigned to from within statement bodies

			int result;     
			if (true /* aBool */)
			{
				result = 42; 
			}
			//Console.WriteLine("result={0}", result);

			/*
				Because the if-then block is a statement, 
				the result variable must be defined outside the statement 
				but assigned to from inside the statement, which leads to issues such as:

					-	What initial value should result be set to?
					-	What if I forget to assign to the result variable?
					-	What is the value of the result variable in the "else" case?
			*/

			// same code, rewritten in an expression-oriented style:

			result = (true /*aBool*/) ? 42 : 0;
			Console.WriteLine("result={0}", result);


			//	The result variable is declared at the same time that it is assigned. 

			//	No variables have to be set up "outside" the expression and there 
			//	is no worry about what initial value they should be set to.

			//	The "else" is explicitly handled. 
			//	There is no chance of forgetting to do an assignment in one of the branches.

			//	It is not possible to forget to assign result, 
			//	because then the variable would not even exist!	

		}
	}
}
